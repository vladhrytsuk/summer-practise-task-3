package com.car.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders
{
    @Id
    @Column(name = "orderId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "breaking")
    private String breaking;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users usersOrder;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_has_cars",
            joinColumns = @JoinColumn(name = "carId"),
            inverseJoinColumns = @JoinColumn(name = "orderId"))
    private List<Car> carList = new ArrayList<>();

    public Orders()
    {

    }

    public Orders(String breaking, String status, Users usersOrder, List<Car> carList)
    {
        this.breaking = breaking;
        this.status = status;
        this.usersOrder = usersOrder;
        this.carList = carList;
    }

    public Long getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
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

    public Users getUsersOrder()
    {
        return usersOrder;
    }

    public void setUsersOrder(Users usersOrder)
    {
        this.usersOrder = usersOrder;
    }

    public List<Car> getCarList()
    {
        return carList;
    }

    public void setCarList(List<Car> carList)
    {
        this.carList = carList;
    }
}
