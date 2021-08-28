package com.Eshop.shop.daos;

import com.Eshop.shop.entitie.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    public Product findById(int id);
    public List<Product> getAllProduct();
}
