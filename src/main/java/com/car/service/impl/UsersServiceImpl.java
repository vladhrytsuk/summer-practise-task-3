package com.car.service.impl;

import com.car.dao.interfaces.RolesDAO;
import com.car.dao.interfaces.UsersDAO;
import com.car.dto.factory.interfaces.FactoryDTO;
import com.car.entity.Car;
import com.car.entity.Orders;
import com.car.entity.Roles;
import com.car.entity.Users;
import com.car.service.exception.EntityNotFound;
import com.car.service.exception.ObjectAlreadyExistsException;
import com.car.service.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService
{

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private RolesDAO rolesDAO;

    @PersistenceContext
    EntityManager em;

    @Autowired
    private FactoryDTO factoryDTO;


    @Transactional (readOnly = true)
    @Override
    public Users getUser(Long userId)
    {
        Users users = findUserById(userId);
        return users;
    }

    @Transactional
    @Override
    public Users addUser(Users users, String secretCode)
    {
        Roles role;
        Users userAdd;
        if (userExist(users.getUsername())) {
            throw new ObjectAlreadyExistsException("User with login " + users.getUsername() + " already exist");
        } else {
            if (secretCode.equals("admin")) {
                role = rolesDAO.findByRole("ROLE_MECHANIC");
            } else {
                role = rolesDAO.findByRole("ROLE_USER");
            }
            List<Roles> roles = new ArrayList<>();
            roles.add(role);
            users.setRoleList(roles);
            userAdd = usersDAO.save(users);
        }
        return factoryDTO.UsersOutDTO(userAdd);
    }

    @Transactional
    @Override
    public void deleteUser(Long userId)
    {
        Users deleteUser = findUserById(userId);
        if (deleteUser == null) {
            throw new EntityNotFound();
        } else {
            usersDAO.delete(deleteUser);
        }
    }

    @Transactional (readOnly = true)
    @Override
    public List<Orders> getUserOrders(Long userId)
    {
        return em.createQuery("SELECT o.orderId, o.breaking, o.status FROM orders o WHERE o.userId = :userId", Orders.class)
                .setParameter("userId", 1)
                .getResultList();
    }

    @Transactional (readOnly = true)
    @Override
    public List<Car> getUserCars(Long userId)
    {
        return em.createQuery("SELECT c.carId, c.mark, c.color, c.miles, c.vin FROM cars c WHERE c.userId = :userId", Car.class)
                .setParameter("userId", 1)
                .getResultList();
    }

    @Override
    public Users findUserById(Long userId)
    {
        return usersDAO.findOne(userId);
    }

    @Override
    public Users findByUsername(String username)
    {
        return usersDAO.findByUsername(username);
    }

    @Transactional (readOnly = true)
    @Override
    public List<Users> getAllUsers()
    {
        return (List<Users>) usersDAO.findAll();
    }

    private boolean userExist(String username) {
        return usersDAO.findByUsername(username) != null;
    }

}
