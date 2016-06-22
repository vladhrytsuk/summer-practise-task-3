package com.car.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Users
{
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;

    @NotEmpty
    @Column(name="login")
    private String login;

    @NotEmpty
    @Column(name="password")
    private String password;

    @NotEmpty
    @Column(name="email")
    private String email;

    @NotEmpty
    @Column(name="firstName")
    private String firstName;

    @NotEmpty
    @Column(name="lastName")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_has_users", joinColumns = {
            @JoinColumn(name = "users_user_id") },
            inverseJoinColumns = { @JoinColumn(name = "roles_role_id") })
    private List<Roles> roleList;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Car> carList = new ArrayList<Car>();

    @OneToMany(fetch = FetchType.EAGER)
    private List<Orders> ordersList = new ArrayList<Orders>();

    public Users()
    {

    }

    public Users(String login, String password, String email, String firstName, String lastName, List<Roles> roleList, List<Car> carList, List<Orders> ordersList)
    {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleList = roleList;
        this.carList = carList;
        this.ordersList = ordersList;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
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
}