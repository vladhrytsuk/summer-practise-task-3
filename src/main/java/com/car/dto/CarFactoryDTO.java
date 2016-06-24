package com.car.dto;

import com.car.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarFactoryDTO
{
    public Car SerializerCar (CarDTO carDTO)
    {
        Car car = new Car();
        car.setMark(carDTO.getMark());
        car.setColor(carDTO.getColor());
        car.setVin(carDTO.getVin());
        car.setMiles(carDTO.getMiles());
        return car;
    }

    public Car setIdCar (Car car, Long car_id)
    {
        car.setCar_id(car_id);
        return car;
    }
}
