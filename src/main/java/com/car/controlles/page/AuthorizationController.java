package com.car.controlles.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthorizationController
{
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public String LoginPage()
    {
        logger.debug("Login controller");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String  AuthorizationPage()
    {
        logger.debug("Login controller");
        return "redirect:/user/homepage";
    }


}
