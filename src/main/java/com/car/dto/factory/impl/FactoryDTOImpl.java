package com.car.dto.factory.impl;


import com.car.dao.interfaces.UsersDAO;
import com.car.dto.factory.interfaces.FactoryDTO;
import com.car.dto.to.OrderDTO;
import com.car.dto.to.OrderOutDTO;
import com.car.dto.to.UserAuDTO;
import com.car.dto.to.UserDTO;
import com.car.entity.Car;
import com.car.entity.Orders;
import com.car.entity.Roles;
import com.car.entity.Users;
import com.car.service.interfaces.CarService;
import com.car.service.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FactoryDTOImpl implements FactoryDTO
{

    @Autowired
    private UsersService usersService;

    @Autowired
    private CarService carService;

    @Autowired
    private UsersDAO usersDAO;

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
    public Car CarInDTO(OrderDTO orderDTO) {
        return CarOutDTO(carService.findById(orderDTO.getCarId()));
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
    public Orders OrdersInDTO(OrderDTO orderDTO) {
        Orders orderOut = new Orders();
        orderOut.setBreaking(orderDTO.getBreaking());
        orderOut.setStatus("Adopted");
        return orderOut;
    }

    @Override
    public List<OrderOutDTO> OrderOutListDTO(List<Orders> orders) {
        List<OrderOutDTO> orderOutDTOList = new ArrayList<>(orders.size());
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users users = usersDAO.findByUsername(userDetails.getUsername());
        if(userDetails.getAuthorities().toString().equals("[ROLE_MECHANIC]")){
            for(Orders o: orders)
            {
                if (o.getMechanicId().equals(users.getUserId())) {
                    List<Car> car = o.getCarList();
                    for (Car c : car) {
                        orderOutDTOList.add(new OrderOutDTO(
                                o.getOrderId(),
                                o.getUsersOrder().getUsername(),
                                c.getMark(),
                                c.getColor(),
                                c.getVin(),
                                c.getMiles(),
                                o.getBreaking(),
                                o.getStatus()
                        ));
                    }
                }
            }
            return orderOutDTOList;
        } else {
            for(Orders o: orders)
            {
                Users mechanic = usersDAO.findOne(o.getMechanicId());
                if (o.getUsersOrder().getUserId().equals(users.getUserId())) {
                    List<Car> car = o.getCarList();
                    for (Car c : car) {
                        orderOutDTOList.add(new OrderOutDTO(
                                o.getOrderId(),
                                mechanic.getUsername(),
                                c.getMark(),
                                c.getColor(),
                                c.getVin(),
                                c.getMiles(),
                                o.getBreaking(),
                                o.getStatus()
                        ));
                    }
                }
            }
            return orderOutDTOList;
        }


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
    public Users UsersInDTO(OrderDTO orderDTO) {
        return UsersOutDTO(usersService.findByUsername(orderDTO.getUsername()));
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
    public OrderOutDTO OrdersOutDTO(Users users, Car car, Orders orders) {
        return new OrderOutDTO(
                orders.getOrderId(),
                users.getUsername(),
                car.getMark(),
                car.getColor(),
                car.getVin(),
                car.getMiles(),
                orders.getBreaking(),
                orders.getStatus()
        );
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
