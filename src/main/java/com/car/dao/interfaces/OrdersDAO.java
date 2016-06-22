package com.car.dao.interfaces;

import com.car.entity.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDAO extends CrudRepository<Orders, Long>
{

}
