package com.car.service.impl;

import com.car.dao.interfaces.OrdersDAO;
import com.car.dao.interfaces.UsersDAO;
import com.car.dto.factory.interfaces.FactoryDTO;
import com.car.entity.Orders;
import com.car.entity.Users;
import com.car.service.exception.EntityNotFound;
import com.car.service.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService
{

    @Autowired
    private OrdersDAO ordersDAO;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private FactoryDTO factoryDTO;

    @Transactional
    @Override
    public Orders addOrders(Orders orders)
    {
        Orders orderAdd;
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users usersOrder = usersDAO.findByUsername(userDetails.getUsername());
        orders.setUsersOrder(usersOrder);
        orderAdd = ordersDAO.save(orders);
        return factoryDTO.OrdersOutDTO(orderAdd);
    }

    @Transactional
    @Override
    public Orders deleteOrders(Long orderId)
    {
        Orders deletedOrder = findById(orderId);
        if (deletedOrder == null) {
            throw new EntityNotFound();
        } else {
            ordersDAO.delete(deletedOrder);
        }
        return factoryDTO.OrdersOutDTO(deletedOrder);
    }

    @Transactional
    @Override
    public Orders updateOrders(Orders orders)
    {
        Orders updatedOrder = findById(orders.getOrderId());
        if (updatedOrder == null) {
            throw new EntityNotFound();
        } else {
            updatedOrder.setBreaking(orders.getBreaking());
            updatedOrder.setStatus(orders.getStatus());
        }
        return factoryDTO.OrdersOutDTO(updatedOrder);
    }

    @Transactional (readOnly = true)
    @Override
    public Orders getOrders(Long orderId)
    {
        Orders orderFind = findById(orderId);
        return factoryDTO.OrdersOutDTO(orderFind);
    }

    @Transactional (readOnly = true)
    @Override
    public Orders findById(Long orderId)
    {
        return ordersDAO.findOne(orderId);
    }

    @Transactional (readOnly = true)
    @Override
    public List<Orders> getOrdersUsers(Long userId)
    {
        return em.createQuery("SELECT o FROM orders o WHERE o.userId = :userId", Orders.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Transactional (readOnly = true)
    @Override
    public List<Orders> findAll()
    {
        return (List<Orders>) ordersDAO.findAll();
    }
}
