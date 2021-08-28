package com.Eshop.shop.entitie;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="eshop_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User uder;
    @ManyToOne
    @JoinColumn(name = "product_product_id", nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "sipping_address_id", nullable = false)
    private Address address;
    @Column(nullable = true)
    private double amount;
    @Column(name="order_date", nullable = false)
    private LocalDateTime date;

    public Order(int id, User uder, Product product, Address address, double amount, LocalDateTime date) {
        this.id = id;
        this.uder = uder;
        this.product = product;
        this.address = address;
        this.amount = amount;
        this.date = date;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUder() {
        return uder;
    }

    public void setUder(User uder) {
        this.uder = uder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uderId=" + uder +
                ", product=" + product +
                ", address=" + address +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
