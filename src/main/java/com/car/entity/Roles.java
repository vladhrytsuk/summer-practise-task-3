package com.car.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Roles
{
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long role_id;

    @Column(name = "role")
    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_has_users", joinColumns = {
            @JoinColumn(name = "roles_role_id") },
            inverseJoinColumns = { @JoinColumn(name = "users_user_id") })
    private List<Users> userList;

    public Roles()
    {

    }

    public Roles(String role, List<Users> userList)
    {
        this.role = role;
        this.userList = userList;
    }

    public Long getRole_id()
    {
        return role_id;
    }

    public void setRole_id(Long role_id)
    {
        this.role_id = role_id;
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

    @Override
    public String toString() {
        return "Roles{" +
                "role_id=" + role_id +
                ", role='" + role + '\'' +
                ", userList=" + userList +
                '}';
    }
}
