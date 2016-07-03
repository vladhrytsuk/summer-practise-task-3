package com.car.dto.factory.impl;


import com.car.dto.factory.interfaces.FactoryDTO;
import com.car.dto.to.UserAuDTO;
import com.car.dto.to.UserDTO;
import com.car.entity.Car;
import com.car.entity.Orders;
import com.car.entity.Roles;
import com.car.entity.Users;
import com.car.service.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FactoryDTOImpl implements FactoryDTO
{

    @Autowired
    private UsersService usersService;

    @Override
    public Car CarOutDTO(Car car)
    {
        Car carOut = new Car();
        carOut.setCarId(car.getCarId());
        carOut.setMark(car.getMark());
        carOut.setColor(car.getColor());
        carOut.setVin(car.getVin());
        carOut.setMiles(car.getMiles());
        return carOut;
    }

    @Override
    public Orders OrdersOutDTO(Orders orders)
    {
        Orders orderOut = new Orders();
        orderOut.setOrderId(orders.getOrderId());
        orderOut.setBreaking(orders.getBreaking());
        orderOut.setStatus(orders.getStatus());
        return orderOut;
    }

    @Override
    public Users UsersOutDTO(UserDTO userDTO)
    {
        Users userOut = new Users();
        userOut.setUsername(userDTO.getUsername());
        userOut.setPassword(userDTO.getPassword());
        userOut.setEmail(userDTO.getEmail());
        userOut.setFirstName(userDTO.getFirstName());
        userOut.setLastName(userDTO.getLastName());
        return userOut;
    }

    @Override
    public Users UsersOutDTO(Users users)
    {
        Users userOut = new Users();
        userOut.setUserId(users.getUserId());
        userOut.setUsername(users.getUsername());
        userOut.setPassword(users.getPassword());
        userOut.setEmail(users.getEmail());
        userOut.setFirstName(users.getFirstName());
        userOut.setLastName(users.getLastName());
        return userOut;
    }

    @Override
    public List<Users> UserOutListDTO(List<Users> users) {
        List<Users> userOut = new ArrayList<>(users.size());
        for(Users u: users)
        {
            userOut.add(new Users(u.getUsername(), u.getEmail(), u.getFirstName(), u.getLastName()));
        }
        return userOut;
    }

    @Override
    public Roles RolesOutDTO(Roles roles)
    {
        Roles roleOut = new Roles();
        roleOut.setRoleId(roles.getRoleId());
        roleOut.setRole(roles.getRole());
        return roleOut;
    }

    @Override
    public String CutSecretCode(UserDTO userDTO)
    {
        return userDTO.getSecretCode();
    }


    @Override
    public List<Car> CarOutListDTO(List<Car> car)
    {
        List<Car> carOut = new ArrayList<>(car.size());
        for(Car c: car)
        {
            carOut.add(new Car(c.getCarId(), c.getMark(), c.getColor(), c.getVin(), c.getMiles()));
        }
        return carOut;
    }
}
