package com.car.service.impl;

import com.car.dao.interfaces.RolesDAO;
import com.car.entity.Roles;
import com.car.service.interfaces.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RolesServiceImpl implements RolesService
{
    @Autowired
    private RolesDAO rolesDAO;

    @Override
    public Roles addRole(Roles roles)
    {
        return rolesDAO.save(roles);
    }

    @Override
    public Roles getRole(Long role_id)
    {
        Roles roles = new Roles();
        return roles;
    }

    @Override
    public List<Roles> getAllRoles()
    {
        return null;
    }

    @Override
    public void deleteRole(Long role_id)
    {

    }

    @Override
    public void setRoleUser(Long user_id)
    {

    }
}
