package com.Eshop.shop.dtos;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderDTO {

    private int id;
    private int uderId;
    private int productId;
    private int addressId;
    private double amount;
    private LocalDateTime date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUderId() {
        return uderId;
    }

    public void setUderId(int uderId) {
        this.uderId = uderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
