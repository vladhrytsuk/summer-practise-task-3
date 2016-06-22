package com.car.dao.interfaces;

import com.car.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDAO extends CrudRepository<Car, Long>
{

}
