package com.car.service.interfaces;

import com.car.entity.Car;
import com.car.entity.Users;

import java.util.List;

public interface CarService
{
    Car addCar(Car car, Users user);
    Car deleteCar(Long carId);
    Car updateCar(Car car);
    Car findById(Long carId);
    Car getCar(Long carId);
    List<Car> getCarUser(Long userId);
    List<Car> findAll();
}
