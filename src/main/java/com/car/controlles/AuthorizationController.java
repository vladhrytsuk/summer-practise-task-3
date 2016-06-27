package com.car.controlles;

import com.car.dto.UserAuDTO;
import com.car.dto.UserFactoryDTO;
import com.car.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorizationController
{

    @Autowired
    private UserFactoryDTO userFactoryDTO;

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String LoginPage()
    {
        logger.debug("Login controller");
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public Users AuthorizationPage(@RequestBody UserAuDTO userAuDTO)
    {
        logger.debug("Login controller");
        return userFactoryDTO.FindUser(userAuDTO);
    }

}
