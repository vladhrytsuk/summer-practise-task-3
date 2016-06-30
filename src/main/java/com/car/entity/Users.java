package com.car.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class Users /*implements UserDetails*/
{
    @Id
    @Column(name = "userId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotEmpty
    @Column(name="username", unique = true)
    private String username;

    @NotEmpty
    @Column(name="password")
    private String password;

    @NotEmpty
    @Column(name="email", unique = true)
    private String email;

    @NotEmpty
    @Column(name="firstName")
    private String firstName;

    @NotEmpty
    @Column(name="lastName")
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "roles_has_users",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    private List<Roles> roleList = new ArrayList<>();

    @OneToMany(mappedBy = "usersCar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> carList = new ArrayList<>();

    @OneToMany(mappedBy = "usersOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> ordersList = new ArrayList<>();

    public Users()
    {

    }

    public Users(String username, String password, String email, String firstName, String lastName)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Users(String username, String password, String email, String firstName, String lastName, List<Roles> roleList, List<Car> carList, List<Orders> ordersList)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleList = roleList;
        this.carList = carList;
        this.ordersList = ordersList;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public List<Roles> getRoleList()
    {
        return roleList;
    }

    public void setRoleList(List<Roles> roleList)
    {
        this.roleList = roleList;
    }

    public List<Car> getCarList()
    {
        return carList;
    }

    public void setCarList(List<Car> carList)
    {
        this.carList = carList;
    }

    public List<Orders> getOrdersList()
    {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList)
    {
        this.ordersList = ordersList;
    }
}
