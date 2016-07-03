package com.car.dao.interfaces;

import com.car.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDAO extends CrudRepository<Car, Long>
{
    /*@Query("select c from Cars c where c.usersCar.userId = ?1")
    List<Car> getUserCars(Long userId);*/
}
