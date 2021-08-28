package com.Eshop.shop.services;

import com.Eshop.shop.daos.OrderDao;
import com.Eshop.shop.entitie.Order;
import com.Eshop.shop.exceptions.OrderDetalisNotFoundException;
import com.Eshop.shop.exceptions.ProductDetailsNotFoundException;
import com.Eshop.shop.exceptions.UserDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImp implements OrderService{
    @Autowired
   public OrderDao orderDao;

    @Override
    public Order acceptOrderDetails(Order order) throws ProductDetailsNotFoundException, UserDetailsNotFoundException {
        return orderDao.save(order);
    }

    @Override
    public Order getOrderDetails(int id) throws OrderDetalisNotFoundException {

        return orderDao.findById(id);
    }

    @Override
    public boolean deleteOrder(int id) throws OrderDetalisNotFoundException {
        Order order=getOrderDetails(id);
        orderDao.delete(order);
        return true;
    }

    @Override
    public List<Order> getAllOrderDetails() {
        return orderDao.getAllOrders();
    }
}
