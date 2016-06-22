package com.car.service.interfaces;

import com.car.entity.Roles;

import java.util.List;

public interface RolesService
{
    Roles addRole(Roles roles);
    Roles getRole(Long role_id);
    List<Roles> getAllRoles();
    void deleteRole(Long role_id);
    void setRoleUser(Long user_id);
}
