package com.car.dto.factory.interfaces;

import com.car.dto.to.UserAuDTO;
import com.car.dto.to.UserDTO;
import com.car.entity.Car;
import com.car.entity.Orders;
import com.car.entity.Roles;
import com.car.entity.Users;

import java.util.List;

public interface FactoryDTO
{
    Car CarOutDTO (Car car);
    List<Car> CarOutListDTO (List<Car> car);

    Orders OrdersOutDTO (Orders orders);
    Roles RolesOutDTO (Roles roles);

    Users UsersOutDTO (UserDTO userDTO);
    Users UsersOutDTO (Users users);
    List<Users> UserOutListDTO (List<Users> users);
    String CutSecretCode (UserDTO userDTO);

}
