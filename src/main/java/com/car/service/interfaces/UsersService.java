package com.car.service.interfaces;

import com.car.entity.Car;
import com.car.entity.Orders;
import com.car.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsersService /*extends UserDetailsService*/
{
    Users getUser(Long user_id);
    Users addUser(Users users);
    void deleteUser(Long user_id);
    List<Orders> getUserOrders(Long user_id);
    List<Car> getUserCars(Long user_id);
    Users findUserById(Long user_id);
    Users findUserByLogin(String login);
    List<Users> getAllUsers();

}
