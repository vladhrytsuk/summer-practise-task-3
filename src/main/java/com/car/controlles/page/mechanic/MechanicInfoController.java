package com.car.controlles.page.mechanic;

import com.car.entity.Users;
import com.car.service.interfaces.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MechanicInfoController
{
    @Autowired
    private UsersService usersService;

    private static final Logger logger = LoggerFactory.getLogger(MechanicInfoController.class);

    @RequestMapping(value = "/mechanic/homepage", method = RequestMethod.GET)
    public String UserPage(Model model)
    {
        UserDetails userDetail = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users users = usersService.findByUsername(userDetail.getUsername());

        model.addAttribute("username", userDetail.getUsername());
        model.addAttribute("email", users.getEmail());
        model.addAttribute("firstName", users.getFirstName());
        model.addAttribute("lastName", users.getLastName());
        logger.debug("Mechanic controller");
        return "mechanic/mechanic";
    }

    @RequestMapping(value = "/mechanic/edit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String UserEditPage()
    {
        logger.debug("User edit page controller");
        return "/mechanic/edit";
    }

    @RequestMapping(value = "/mechanic/delete", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String UserDeletePage()
    {
        logger.debug("User delete page controller");
        return "/mechanic/edit";
    }
}
