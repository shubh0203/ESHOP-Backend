package com.Eshop.shop.services;

import com.Eshop.shop.entitie.Order;
import com.Eshop.shop.exceptions.OrderDetalisNotFoundException;
import com.Eshop.shop.exceptions.ProductDetailsNotFoundException;
import com.Eshop.shop.exceptions.UserDetailsNotFoundException;

import java.util.List;

public interface OrderService {
    public Order acceptOrderDetails(Order order) throws ProductDetailsNotFoundException, UserDetailsNotFoundException;
    public Order getOrderDetails(int id) throws OrderDetalisNotFoundException;
    public boolean deleteOrder(int id) throws OrderDetalisNotFoundException;
    public List<Order> getAllOrderDetails();
}
