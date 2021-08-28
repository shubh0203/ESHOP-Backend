package com.Eshop.shop.utils;

import com.Eshop.shop.dtos.OrderDTO;
import com.Eshop.shop.entitie.Order;
import com.Eshop.shop.exceptions.AddressDetailsNotFoundException;
import com.Eshop.shop.exceptions.OrderDetalisNotFoundException;
import com.Eshop.shop.exceptions.ProductDetailsNotFoundException;
import com.Eshop.shop.exceptions.UserDetailsNotFoundException;
import com.Eshop.shop.services.AddressService;
import com.Eshop.shop.services.ProductService;
import com.Eshop.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOEntityConverter {
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    AddressService addressService;

    public Order convertToBookingEntity(OrderDTO orderDTO) throws UserDetailsNotFoundException, AddressDetailsNotFoundException, ProductDetailsNotFoundException, OrderDetalisNotFoundException {
        Order order = new Order();
        order.setUder(userService.getUserDetails(orderDTO.getUderId()));
        order.setProduct(productService.getProductDetails(orderDTO.getProductId()));
        order.setAddress(addressService.getAddressDetails(orderDTO.getAddressId()));
        order.setAmount(orderDTO.getAmount());
        order.setId(orderDTO.getId());
        return order;
    }
}
