package com.car.service.interfaces;

import com.car.dto.to.OrderDTO;
import com.car.dto.to.OrderOutDTO;
import com.car.entity.Orders;

import java.util.List;

public interface OrdersService
{
    OrderOutDTO addOrders(OrderDTO orderDTO);
    Orders deleteOrders(Long orderId);
    Orders updateOrders(Orders orders);
    Orders getOrders(Long orderId);
    Orders findById(Long orderId);
    List<Orders> getOrdersUsers(Long userId);
    List<OrderOutDTO> getOrdersList();
    List<Orders> findAll();
}
