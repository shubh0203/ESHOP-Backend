package com.Eshop.shop.daos;

import com.Eshop.shop.entitie.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order,Integer> {
    public Order findById(int id);
    public List<Order> getAllOrders();
}
