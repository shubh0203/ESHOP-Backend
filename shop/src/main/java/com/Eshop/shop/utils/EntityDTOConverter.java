package com.Eshop.shop.utils;

import com.Eshop.shop.dtos.OrderDTO;
import com.Eshop.shop.entitie.Order;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class EntityDTOConverter {
    public OrderDTO convertToBookingDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUderId(order.getUder().getId());
        orderDTO.setAddressId(order.getAddress().getId());
        orderDTO.setDate(order.getDate());
        orderDTO.setAmount(order.getAmount());
        orderDTO.setId(order.getId());
        orderDTO.setProductId(order.getProduct().getProductId());
        return orderDTO;
    }
}
