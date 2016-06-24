package com.car.service.impl;

import com.car.dto.CarDTO;
import com.car.dto.CarFactoryDTO;
import com.car.entity.Car;
import com.car.dao.interfaces.CarDAO;
import com.car.service.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService
{
    @Autowired
    private CarDAO carDAO;

    @Autowired
    private CarFactoryDTO carFactoryDTO;

    @Transactional
    @Override
    public Car saveCar(CarDTO carDTO)
    {
        Car carSave = carFactoryDTO.SerializerCar(carDTO);
        carDAO.save(carSave);
        Car car = carFactoryDTO.setIdCar(carSave, carDAO.save(carSave).getCar_id());
        return car;
    }

    @Transactional
    @Override
    public Car deleteCar(Long car_id)
    {
        Car deletedCar = findById(car_id);
        carDAO.delete(deletedCar);
        return deletedCar;
    }

    @Transactional
    @Override
    public Car updateCar(Car car)
    {
        Car updatedCar = findById(car.getCar_id());
        updatedCar.setMark(car.getMark());
        updatedCar.setColor(car.getColor());
        updatedCar.setVin(car.getVin());
        updatedCar.setMiles(car.getMiles());
        return updatedCar;
    }

    @Transactional(readOnly = true)
    @Override
    public Car findById(Long car_id)
    {
        return carDAO.findOne(car_id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> findAll()
    {
        return (List<Car>) carDAO.findAll();
    }
}
