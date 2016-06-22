package com.car.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders
{
    @Id
    @Column(name = "orders_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orders_id;

    @Column(name = "breaking")
    private String breaking;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "orders_order_id")
    private Users users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "orders_has_cars", joinColumns = {
            @JoinColumn(name = "orders_order_id") },
            inverseJoinColumns = { @JoinColumn(name = "cars_car_id") })
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

    public long getOrders_id()
    {
        return orders_id;
    }

    public void setOrders_id(long orders_id)
    {
        this.orders_id = orders_id;
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
                "orders_id=" + orders_id +
                ", breaking='" + breaking + '\'' +
                ", status='" + status + '\'' +
                ", users=" + users +
                ", carList=" + carList +
                '}';
    }
}
