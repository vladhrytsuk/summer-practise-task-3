package com.car.service.impl;

import com.car.dao.interfaces.UsersDAO;
import com.car.entity.Car;
import com.car.entity.Orders;
import com.car.entity.Users;
import com.car.service.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService
{

    @Autowired
    private UsersDAO usersDAO;

    @Override
    public Users getUser(Long user_id)
    {
        Users users = findUserById(user_id);
        return users;
    }

    @Override
    public Users addUser(Users users)
    {
        return usersDAO.save(users);
    }

    @Override
    public void deleteUser(Long user_id)
    {
        Users deleteUser = findUserById(user_id);
        usersDAO.delete(deleteUser);
    }

    @Override
    public List<Orders> getUserOrders(Long user_id)
    {
        return null;
    }

    @Override
    public List<Car> getUserCars(Long user_id)
    {
        return null;
    }

    @Override
    public Users findUserById(Long user_id)
    {
        return usersDAO.findOne(user_id);
    }

    @Override
    public Users findUserByLogin(String login)
    {
        return null;
    }

    @Override
    public List<Users> getAllUsers()
    {
        return (List<Users>) usersDAO.findAll();
    }

/*    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }*/
}
