package com.car.service.interfaces;

import com.car.entity.Orders;
import com.car.entity.Users;

import java.util.List;

public interface OrdersService
{
    Orders addOrders(Orders orders, Users user);
    Orders deleteOrders(Long orderId);
    Orders updateOrders(Orders orders);
    Orders getOrders(Long orderId);
    Orders findById(Long orderId);
    List<Orders> getOrdersUsers(Long userId);
    List<Orders> findAll();
}
