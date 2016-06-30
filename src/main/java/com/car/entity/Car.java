package com.car.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car
{
    @Id
    @Column(name = "carId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

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
    @JoinColumn(name = "userId")
    private Users usersCar;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "orders_has_cars", joinColumns = {
            @JoinColumn(name = "orderId") },
            inverseJoinColumns = { @JoinColumn(name = "carId") })
    private List<Orders> ordersList = new ArrayList<>();

    public Car()
    {

    }

    public Car(Long carId, String mark, String color, int vin, int miles) {
        this.carId = carId;
        this.mark = mark;
        this.color = color;
        this.vin = vin;
        this.miles = miles;
    }

    public Car(String mark, String color, int vin, int miles, Users usersCar, List<Orders> ordersList) {
        this.mark = mark;
        this.color = color;
        this.vin = vin;
        this.miles = miles;
        this.usersCar = usersCar;
        this.ordersList = ordersList;
    }

    public Long getCarId()
    {
        return carId;
    }

    public void setCarId(Long carId)
    {
        this.carId = carId;
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

    public Users getUsersCar()
    {
        return usersCar;
    }

    public void setUsersCar(Users usersCar)
    {
        this.usersCar = usersCar;
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
