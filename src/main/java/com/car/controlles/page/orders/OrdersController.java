package com.car.controlles.page.orders;

import com.car.entity.Orders;
import com.car.service.interfaces.OrdersService;
import com.car.service.interfaces.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class OrdersController
{
    @Autowired
    private UsersService usersService;

    @Autowired
    private OrdersService ordersService;

    private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);

    @ResponseBody
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView List()
    {
        logger.debug("LIST controller");
        return new ModelAndView("user/ordes");
    }

    @ResponseBody
    @RequestMapping(value = "/order/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Orders saveOrders(@RequestBody @Valid Orders orders)
    {
        logger.debug("Order add controller");
        return ordersService.addOrders(orders);
    }

    @ResponseBody
    @RequestMapping(value = "/getOrder", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public Orders getOrders(@RequestBody @Valid Orders orders)
    {
        logger.debug("Order add controller");
        return ordersService.addOrders(orders);
    }

}