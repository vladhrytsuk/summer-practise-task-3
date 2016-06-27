package com.car.controlles;

import com.car.dto.UserDTO;
import com.car.dto.UserFactoryDTO;
import com.car.entity.Users;
import com.car.service.interfaces.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegistrationController
{
    @Autowired
    private UsersService usersService;

    @Autowired
    private UserFactoryDTO userFactoryDTO;

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationPage()
    {
        logger.debug("Registration controller");
        return "registration";
    }

    @ResponseBody
    @RequestMapping(value = "/makeRegistration", method = RequestMethod.POST)
    public Users makeRegistrationPage(@RequestBody UserDTO userDTO)
    {
        logger.debug("makeRegistration controller");
        return usersService.addUser(userFactoryDTO.CutCode(userDTO), userFactoryDTO.CutUser(userDTO));
    }


}
