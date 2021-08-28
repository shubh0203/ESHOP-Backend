package com.Eshop.shop.controllers;

import com.Eshop.shop.dtos.OrderDTO;
import com.Eshop.shop.dtos.ProductDTO;
import com.Eshop.shop.dtos.UserDTO;
import com.Eshop.shop.entitie.Order;
import com.Eshop.shop.entitie.Product;
import com.Eshop.shop.exceptions.*;
import com.Eshop.shop.services.AddressService;
import com.Eshop.shop.services.OrderService;
import com.Eshop.shop.services.ProductService;
import com.Eshop.shop.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class OrderControler {
    @Autowired
    AddressService addressService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;

    @PostMapping(value="/products",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newOrder(@RequestBody int AddressId ,int ProductId , @RequestHeader(value = "ACCESS-TOKEN") String token) throws APIException, BadCredentialsException, UserDetailsNotFoundException, AddressDetailsNotFoundException, ProductDetailsNotFoundException {
        if(token == null)
            throw new APIException("Please add proper authentication");
        if(userService.getUserDetailsByUsername(token).getRole().equalsIgnoreCase("Admin"))
            throw new BadCredentialsException("This feature is only available to admin");
        if(AddressId<=0 || addressService.getAddressDetails(AddressId)==null)
            throw new AddressDetailsNotFoundException("Address details not found form this id pleace enter id");
        if(ProductId<=0 || productService.getProductDetails(ProductId)==null)
            throw new ProductDetailsNotFoundException("product not found from this id pleace enter valid id");
        Order newOrder=new Order();
        newOrder.setAmount(productService.getProductDetails(ProductId).getPrice());
        newOrder.setAddress(addressService.getAddressDetails(AddressId));
        newOrder.setUder(userService.getUserDetailsByUsername(token));
        newOrder.setProduct(productService.getProductDetails(ProductId));
        newOrder.setDate(LocalDateTime.now());
        orderService.acceptOrderDetails(newOrder);
        OrderDTO savedOrderDTO = modelMapper.map(newOrder, OrderDTO.class);
        return new ResponseEntity<>(savedOrderDTO, HttpStatus.CREATED);
    }
}
