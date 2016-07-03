package com.car.service.interfaces;

import com.car.entity.Roles;

import java.util.List;

public interface RolesService
{
    Roles addRole(Roles roles);
    Roles getRole(Long roleId);
    List<Roles> getAllRoles();
    void deleteRole(Long roleId);
    void setRoleUser(Long roleId, Long userId);
    Roles findByRole(String role);
    Roles findById(Long roleId);
}
