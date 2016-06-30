package com.car.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Roles
{
    @Id
    @Column(name = "roleId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name = "role", nullable = false)
    private String role;

    @ManyToMany(mappedBy = "roleList", cascade = CascadeType.ALL)
    private List<Users> userList;

    public Roles()
    {

    }

    public Roles(String role) {
        this.role = role;
    }

    public Roles(String role, List<Users> userList)
    {
        this.role = role;
        this.userList = userList;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public List<Users> getUserList()
    {
        return userList;
    }

    public void setUserList(List<Users> userList)
    {
        this.userList = userList;
    }
}
