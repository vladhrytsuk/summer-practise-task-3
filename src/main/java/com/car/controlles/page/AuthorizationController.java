package com.car.controlles.page;

import com.car.entity.Users;
import com.car.service.interfaces.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorizationController
{

    @Autowired
    private UsersService usersService;

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
        UserDetails userDetail = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userDetail.getAuthorities().toString().equals("[ROLE_USER]"))
        {
            logger.debug("Login user controller");
            return "redirect:/user/homepage";
        }
        else
        {
            logger.debug("Login mechanic controller");
            return "redirect:/mechanic/homepage";
        }
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
