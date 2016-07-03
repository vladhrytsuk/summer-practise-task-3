package com.car.service.interfaces;

import com.car.entity.Car;

import java.util.List;

public interface CarService
{
    Car addCar(Car car);
    Car deleteCar(Long carId);
    Car updateCar(Car car);
    Car findById(Long carId);
    Car getCar(Long carId);
    List<Car> getUserCars(Long userId);
    List<Car> findAll();
}
