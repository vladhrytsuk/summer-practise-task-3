package com.car.dao.interfaces;

import com.car.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDAO extends CrudRepository<Users, Long>
{
    Users findByUsername (String username);
}
