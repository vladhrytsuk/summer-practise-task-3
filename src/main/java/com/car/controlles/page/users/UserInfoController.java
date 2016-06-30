package com.car.controlles.page.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserInfoController
{
    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);


/*    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public String UserPage(@PathVariable("username") String username, Model model)
    {
        model.addAttribute("role", "User");
        model.addAttribute("login", username);
        model.addAttribute("email", "vlad-aizen@yandex.by");
        model.addAttribute("firstName", "Vlad");
        model.addAttribute("lastName", "Hrytsuk");

        logger.debug("User controller");
        return "/user/user";
    }*/

    @RequestMapping(value = "/user/homepage", method = RequestMethod.GET)
    public String UserPage(Model model)
    {
        model.addAttribute("role", "User");
        model.addAttribute("login", "URAAAAAAA");
        model.addAttribute("email", "vlad-aizen@yandex.by");
        model.addAttribute("firstName", "Vlad");
        model.addAttribute("lastName", "Hrytsuk");

        logger.debug("User controller");
        return "/user/user";
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String UserEditPage()
    {
        logger.debug("User edit page controller");
        return "/user/edit";
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String UserDeletePage()
    {
        logger.debug("User delete page controller");
        return "/user/user";
    }
}
