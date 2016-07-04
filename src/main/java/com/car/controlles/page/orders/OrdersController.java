package com.car.controlles.page.orders;

import com.car.dto.factory.interfaces.FactoryDTO;
import com.car.dto.to.OrderDTO;
import com.car.dto.to.OrderOutDTO;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrdersController
{
    @Autowired
    private UsersService usersService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private FactoryDTO factoryDTO;

    private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);

    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public List<OrderOutDTO> orderList()
    {
        logger.debug("LIST order controller");
        return ordersService.getOrdersList();
    }


    @ResponseBody
    @RequestMapping(value = "/order/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public OrderOutDTO saveOrders(@RequestBody OrderDTO orderDTO)
    {
        logger.debug("Order add controller");
        return ordersService.addOrders(orderDTO);
    }

    /*@ResponseBody
    @RequestMapping(value = "/getOrder", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public Orders getOrders(@RequestBody @Valid Orders orders)
    {
        logger.debug("Order add controller");
        return ordersService.addOrders(orders);
    }*/

}
