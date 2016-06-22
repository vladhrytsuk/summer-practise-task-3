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
    public Users getUser(Long user_id) {
        return null;
    }

    @Override
    public Long addUser(Users users) {
        return null;
    }

    @Override
    public Long deleteUser(Long user_id) {
        return null;
    }

    @Override
    public List<Orders> getUserOrders(Long user_id) {
        return null;
    }

    @Override
    public List<Car> getUserCars(Long user_id) {
        return null;
    }

    @Override
    public Users findUserById(Long user_id) {
        return null;
    }

    @Override
    public Users findUserByLogin(String login) {
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
