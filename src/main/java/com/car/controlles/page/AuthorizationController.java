package com.car.controlles.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorizationController
{
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public String AuthorizationPage()
    {
        logger.debug("authorization controller");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String  LoginPage()
    {
        logger.debug("Login controller");
        return "redirect:/user/homepage";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String LogoutPage(HttpServletRequest request, HttpServletResponse response)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        logger.debug("logout controller");
        return "redirect:/login?logout";
    }


}
