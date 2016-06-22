package com.car.service.impl;

import com.car.dao.interfaces.OrdersDAO;
import com.car.entity.Orders;
import com.car.service.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService
{

    @Autowired
    private OrdersDAO ordersDAO;

    @Override
    public Orders addOrders(Orders orders) {
        return null;
    }

    @Override
    public Orders deleteOrders(Long order_id) {
        return null;
    }

    @Override
    public Orders updateOrders(Orders orders) {
        return null;
    }

    @Override
    public Orders getOrders(Long order_id) {
        return null;
    }

    @Override
    public Orders findById(Long order_id) {
        return null;
    }

    @Override
    public List<Orders> findAll() {
        return null;
    }
}
