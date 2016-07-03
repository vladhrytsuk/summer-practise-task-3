package com.car.dto.to;

public class OrderOutDTO
{
    Long orderId;
    String username;
    String mark;
    String color;
    int vin;
    int miles;
    String breaking;
    String status;

    public OrderOutDTO(Long orderId, String username, String mark, String color, int vin, int miles, String breaking, String status) {
        this.orderId = orderId;
        this.username = username;
        this.mark = mark;
        this.color = color;
        this.vin = vin;
        this.miles = miles;
        this.breaking = breaking;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public String getBreaking() {
        return breaking;
    }

    public void setBreaking(String breaking) {
        this.breaking = breaking;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
