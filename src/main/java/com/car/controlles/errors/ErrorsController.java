package com.car.controlles.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorsController
{
    private static final Logger logger = LoggerFactory.getLogger(ErrorsController.class);

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String Page403()
    {
        logger.debug("403 controller");
        return "403";
    }
}
