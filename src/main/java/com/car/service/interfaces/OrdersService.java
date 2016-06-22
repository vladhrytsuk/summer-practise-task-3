package com.car.service.interfaces;

import com.car.entity.Orders;

import java.util.List;

public interface OrdersService
{
    Orders addOrders(Orders orders);
    Orders deleteOrders(Long order_id);
    Orders updateOrders(Orders orders);
    Orders getOrders(Long order_id);
    Orders findById(Long order_id);
    List<Orders> findAll();
}
