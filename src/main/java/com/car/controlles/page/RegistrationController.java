package com.car.controlles.page;

import com.car.dto.factory.interfaces.FactoryDTO;
import com.car.dto.to.UserDTO;
import com.car.entity.Users;
import com.car.service.exception.ObjectAlreadyExistsException;
import com.car.service.interfaces.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController
{
    @Autowired
    private UsersService usersService;

    @Autowired
    private FactoryDTO factoryDTO;

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationPage()
    {
        logger.debug("Registration controller");
        return "registration";
    }

    @ResponseBody
    @RequestMapping(value = "/makeRegistration", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Users makeRegistrationPage(@RequestBody UserDTO userDTO) throws ObjectAlreadyExistsException
    {
        logger.debug("makeRegistration controller");
        return usersService.addUser(factoryDTO.UsersOutDTO(userDTO), factoryDTO.CutSecretCode(userDTO));
    }


}
