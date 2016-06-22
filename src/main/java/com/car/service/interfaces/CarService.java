package com.car.service.interfaces;

import com.car.dto.CarDTO;
import com.car.entity.Car;

import java.util.List;

public interface CarService
{
    Car saveCar(CarDTO carDTO);
    Car deleteCar(Long car_id);
    Car updateCar(Car car);
    Car findById(Long car_id);
    List<Car> findAll();
}
