package com.Eshop.shop.entitie;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="eshop_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;

    @Column(name="name" ,nullable=false)
    private String name;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String manufacture;
    @Column(name="available_item",nullable = false)
    private String avelabilty;
    @Column(name="image_url",nullable = false)
    private String image;
    @Column(nullable = false)
    private LocalDateTime created;
    private LocalDateTime updated;

    public Product(int productId, String name, String category, double price, String description, String manufacture, String avelabilty, String image, LocalDateTime created, LocalDateTime updated) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.manufacture = manufacture;
        this.avelabilty = avelabilty;
        this.image = image;
        this.created = created;
        this.updated = updated;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getAvelabilty() {
        return avelabilty;
    }

    public void setAvelabilty(String avelabilty) {
        this.avelabilty = avelabilty;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", avelabilty='" + avelabilty + '\'' +
                ", image='" + image + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
