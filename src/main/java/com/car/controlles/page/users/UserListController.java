package com.car.controlles.page.users;

import com.car.dto.factory.interfaces.FactoryDTO;
import com.car.entity.Users;
import com.car.service.interfaces.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserListController
{
    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UsersService usersService;

    @Autowired
    private FactoryDTO factoryDTO;

    @ResponseBody
    @RequestMapping(value = "/getUser", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public List<Users> getUser()
    {
        logger.debug("USER LIST controller");
        return factoryDTO.UserOutListDTO(usersService.getAllUsers());
    }
}
