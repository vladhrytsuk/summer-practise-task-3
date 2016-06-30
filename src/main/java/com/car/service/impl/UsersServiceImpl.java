package com.car.service.impl;

import com.car.dao.interfaces.RolesDAO;
import com.car.dao.interfaces.UsersDAO;
import com.car.dto.factory.interfaces.FactoryDTO;
import com.car.entity.Car;
import com.car.entity.Orders;
import com.car.entity.Roles;
import com.car.entity.Users;
import com.car.service.exception.ObjectAlreadyExistsException;
import com.car.service.interfaces.RolesService;
import com.car.service.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public Users addUser(Users users, String secretCode) throws ObjectAlreadyExistsException
    {
        if(users == null){
            throw new NullPointerException();
        }
            Users userAdd = null;
            List<Roles> role = new ArrayList<>();
            Roles r = null;

            Users findUser = factoryDTO.UsersOutDTO(usersDAO.findByUsername(users.getUsername()));
           /* Users findUser = factoryDTO.UsersOutDTO(findUserById(users.getUserId()));*/

            if (users.getUsername().equals(findUser.getUsername())) {
                throw new ObjectAlreadyExistsException();
            }
            else
            {
                if (secretCode.equals("admin")) {
                    r = rolesDAO.findOne(2L);
                    role.add(r);
                    users.setRoleList(role);
                    userAdd = usersDAO.save(users);

                } else {
                    r = rolesDAO.findOne(1L);
                    role.add(r);
                    users.setRoleList(role);
                    userAdd = usersDAO.save(users);
                }
            }
            return factoryDTO.UsersOutDTO(userAdd);
    }

    @Transactional
    @Override
    public void deleteUser(Long userId)
    {
        Users deleteUser = findUserById(userId);
        usersDAO.delete(deleteUser);
    }

    @Transactional (readOnly = true)
    @Override
    public List<Orders> getUserOrders(Long userId)
    {
        /*return usersDAO.getUserOrders(userId);*/
                return em.createQuery("SELECT o.orderId, o.breaking, o.status FROM orders o WHERE o.userId = :userId", Orders.class)
                .setParameter("userId", 1)
                .getResultList();
    }

    @Transactional (readOnly = true)
    @Override
    public List<Car> getUserCars(Long userId)
    {
        /*return usersDAO.getUserCars(user_id);*/
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

}
