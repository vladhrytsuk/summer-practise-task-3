package com.car.dto.to;

public class OrderDTO
{
    String username;
    Long carId;
    String breaking;

    public OrderDTO() {
    }

    public OrderDTO(String username, Long carId, String breaking) {
        this.username = username;
        this.carId = carId;
        this.breaking = breaking;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getBreaking() {
        return breaking;
    }

    public void setBreaking(String breaking) {
        this.breaking = breaking;
    }
}
