package com.car.service.interfaces;

import com.car.entity.Car;
import com.car.entity.Orders;
import com.car.entity.Users;
import com.car.service.exception.ObjectAlreadyExistsException;

import java.util.List;

public interface UsersService
{
    Users getUser(Long userId);
    Users addUser(Users users, String secretCode);
    void deleteUser(Long userId);
    List<Orders> getUserOrders(Long userId);
    List<Car> getUserCars(Long userId);
    Users findUserById(Long userId);
    Users findByUsername(String username);
    List<Users> getAllUsers();

}
