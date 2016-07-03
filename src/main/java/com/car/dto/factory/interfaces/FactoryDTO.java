package com.car.dto.factory.interfaces;

import com.car.dto.to.OrderDTO;
import com.car.dto.to.OrderOutDTO;
import com.car.dto.to.UserDTO;
import com.car.entity.Car;
import com.car.entity.Orders;
import com.car.entity.Roles;
import com.car.entity.Users;

import java.util.List;

public interface FactoryDTO
{
    Car CarOutDTO (Car car);
    Car CarInDTO (OrderDTO orderDTO);
    List<Car> CarOutListDTO (List<Car> car);

    Orders OrdersOutDTO (Orders orders);
    Orders OrdersInDTO (OrderDTO orderDTO);
    Roles RolesOutDTO (Roles roles);

    Users UsersOutDTO (UserDTO userDTO);
    Users UsersOutDTO (Users users);
    Users UsersInDTO (OrderDTO orderDTO);
    List<Users> UserOutListDTO (List<Users> users);
    String CutSecretCode (UserDTO userDTO);

    OrderOutDTO OrdersOutDTO (Users users, Car car, Orders orders);

}
