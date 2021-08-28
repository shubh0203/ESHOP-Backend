package com.Eshop.shop.services;

import com.Eshop.shop.entitie.Product;
import com.Eshop.shop.exceptions.ProductDetailsNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    public Product acceptProductDetails(Product product);
    public Product getProductDetails(int id) throws ProductDetailsNotFoundException;
    public Product updateProductDetails(int id, Product product) throws ProductDetailsNotFoundException;
    public boolean deleteProduct(int id) throws ProductDetailsNotFoundException ;
    public List<Product> getAllProductsDetails();
    public List<String> getallCategory();
}
