package com.car.controlles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserInfoController
{
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/user/{login}", method = RequestMethod.GET)
    public String UserPage(@PathVariable("login") String login, Model model)
    {
        model.addAttribute("role", "User");
        model.addAttribute("login", login);
        model.addAttribute("email", "vlad-aizen@yandex.by");
        model.addAttribute("firstName", "Vlad");
        model.addAttribute("lastName", "Hrytsuk");

        logger.debug("User controller");
        return "/user/user";
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
    public String UserEditPage()
    {
        logger.debug("User edit page controller");
        return "/user/edit";
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public String UserDeletePage()
    {
        logger.debug("User delete page controller");
        return "/user/user";
    }
}
