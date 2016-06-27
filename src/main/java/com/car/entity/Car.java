package com.car.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car
{
    @Id
    @Column(name = "car_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long car_id;

    @Column(name = "mark")
    @NotEmpty
    @Size(min = 2, max = 30, message = "Название автомобиля, должно иметь минимум 2 символа, и максимум 30 символов.")
    private String mark;

    @Column(name = "color")
    @NotEmpty
    private String color;

    @Column(name = "vin")
    @Min(value = 1, message = "Vin номер автомобиля, должно начинаться минимум с 1.")
    private int vin;

    @Column(name = "miles")
    @Range(min = 1, max = 9999, message = "Указанный диапозон миль может находиться в пределах от 1 до 9999.")
    private int miles;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "orders_has_cars", joinColumns = {
            @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "car_id") })
    private List<Orders> ordersList;

    public Car()
    {

    }

    public Car(String mark, String color, int vin, int miles, Users users, List<Orders> ordersList) {
        this.mark = mark;
        this.color = color;
        this.vin = vin;
        this.miles = miles;
        this.users = users;
        this.ordersList = ordersList;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public String getMark()
    {
        return mark;
    }

    public void setMark(String mark)
    {
        this.mark = mark;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public int getVin()
    {
        return vin;
    }

    public void setVin(int vin)
    {
        this.vin = vin;
    }

    public int getMiles()
    {
        return miles;
    }

    public void setMiles(int miles)
    {
        this.miles = miles;
    }

    public Users getUsers()
    {
        return users;
    }

    public void setUsers(Users users)
    {
        this.users = users;
    }

    public List<Orders> getOrdersList()
    {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList)
    {
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + car_id +
                ", mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", vin=" + vin +
                ", miles=" + miles +
                ", users=" + users +
                ", ordersList=" + ordersList +
                '}';
    }
}
