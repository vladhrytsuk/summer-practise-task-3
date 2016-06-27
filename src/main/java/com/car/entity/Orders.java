package com.car.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders
{
    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long order_id;

    @Column(name = "breaking")
    private String breaking;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "orders_has_cars", joinColumns = {
            @JoinColumn(name = "car_id") },
            inverseJoinColumns = { @JoinColumn(name = "order_id") })
    private List<Car> carList;

    public Orders()
    {

    }

    public Orders(String breaking, String status, Users users, List<Car> carList)
    {
        this.breaking = breaking;
        this.status = status;
        this.users = users;
        this.carList = carList;
    }

    public Long getOrder_id()
    {
        return order_id;
    }

    public void setOrder_id(Long order_id)
    {
        this.order_id = order_id;
    }

    public String getBreaking()
    {
        return breaking;
    }

    public void setBreaking(String breaking)
    {
        this.breaking = breaking;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Users getUsers()
    {
        return users;
    }

    public void setUsers(Users users)
    {
        this.users = users;
    }

    public List<Car> getCarList()
    {
        return carList;
    }

    public void setCarList(List<Car> carList)
    {
        this.carList = carList;
    }

    @Override
    public String toString()
    {
        return "Orders{" +
                "order_id=" + order_id +
                ", breaking='" + breaking + '\'' +
                ", status='" + status + '\'' +
                ", users=" + users +
                ", carList=" + carList +
                '}';
    }
}
