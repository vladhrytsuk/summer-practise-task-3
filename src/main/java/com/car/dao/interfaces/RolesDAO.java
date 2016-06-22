package com.car.dao.interfaces;

import com.car.entity.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesDAO extends CrudRepository<Roles, Long>
{

}
