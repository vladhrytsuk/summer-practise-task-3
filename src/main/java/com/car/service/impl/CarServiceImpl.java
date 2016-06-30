package com.car.service.impl;

import com.car.dto.factory.interfaces.FactoryDTO;
import com.car.entity.Car;
import com.car.dao.interfaces.CarDAO;
import com.car.entity.Users;
import com.car.service.interfaces.CarService;
import com.car.service.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CarServiceImpl implements CarService
{
    @Autowired
    private CarDAO carDAO;

    @Autowired
    private UsersService usersService;

    @Autowired
    private FactoryDTO factoryDTO;

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public Car addCar(Car car, Users user)
    {
        Car carAdd = null;
        Users usersCar = usersService.findUserById(user.getUserId());
        car.setUsersCar(usersCar);
        carAdd = carDAO.save(car);

        return factoryDTO.CarOutDTO(carAdd);
    }

    @Transactional
    @Override
    public Car deleteCar(Long carId)
    {
        Car deletedCar = findById(carId);
        carDAO.delete(deletedCar);
        return factoryDTO.CarOutDTO(deletedCar);
    }

    @Transactional
    @Override
    public Car updateCar(Car car)
    {
        Car updatedCar = findById(car.getCarId());
        updatedCar.setMark(car.getMark());
        updatedCar.setColor(car.getColor());
        updatedCar.setVin(car.getVin());
        updatedCar.setMiles(car.getMiles());
        return factoryDTO.CarOutDTO(updatedCar);
    }

    @Transactional(readOnly = true)
    @Override
    public Car findById(Long carId)
    {
        return carDAO.findOne(carId);
    }

    @Transactional (readOnly = true)
    @Override
    public Car getCar(Long carId)
    {
        Car carFind = findById(carId);
        return factoryDTO.CarOutDTO(carFind);
    }

    @Transactional (readOnly = true)
    @Override
    public List<Car> getCarUser(Long userId)
    {
        return em.createQuery("SELECT c FROM cars c WHERE c.userId = :userId", Car.class)
        .setParameter("userId", 1)
        .getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> findAll()
    {
        return (List<Car>) carDAO.findAll();
    }
}
