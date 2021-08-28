package com.Eshop.shop.services;

import com.Eshop.shop.daos.ProductDao;
import com.Eshop.shop.entitie.Product;
import com.Eshop.shop.exceptions.ProductDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    public ProductDao productDao;

    @Override
    public Product acceptProductDetails(Product product) {
        return productDao.save(product);
    }

    @Override
    public Product getProductDetails(int id) throws ProductDetailsNotFoundException {
        return productDao.findById(id);
    }

    @Override
    public Product updateProductDetails(int id, Product product) throws ProductDetailsNotFoundException {
        Product newproduct=getProductDetails(id);
        if (isNotNullOrZero(product.getName())) {
            newproduct.setName(product.getName());
        }
        if (isNotNullOrZero(product.getCategory())) {
            newproduct.setCategory(product.getCategory());
        }
        if (isNotNullOrZero(product.getAvelabilty())) {
            newproduct.setAvelabilty(product.getAvelabilty());
        }
        if (isNotNullOrZero(product.getCreated())) {
            newproduct.setCreated(product.getCreated());
        }
        if (isNotNullOrZero(product.getDescription())) {
            newproduct.setDescription(product.getDescription());
        }
        if (isNotNullOrZero(product.getImage())) {
            newproduct.setImage(product.getImage());
        }
        if (isNotNullOrZero(product.getManufacture())) {
            newproduct.setManufacture(product.getManufacture());
        }
        if (isNotNullOrZero(product.getPrice())) {
            newproduct.setPrice(product.getPrice());
        }
        if (isNotNullOrZero(product.getUpdated())) {
            newproduct.setUpdated(product.getUpdated());
        }
        return productDao.save(newproduct);
    }

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }

    @Override
    public boolean deleteProduct(int id) throws ProductDetailsNotFoundException {
        Product product=getProductDetails(id);
        productDao.delete(product);
        return true;
    }

    @Override
    public List<Product> getAllProductsDetails() {
        return productDao.getAllProduct();
    }

    @Override
    public List<String> getallCategory() {
        List<Product> list=getAllProductsDetails();
        Set<String> category=new HashSet<>();
        for(Product productlist:list){
            category.add(productlist.getCategory());
        }
        List<String> categorylist=new ArrayList<>(category);
        return categorylist;

    }
}
