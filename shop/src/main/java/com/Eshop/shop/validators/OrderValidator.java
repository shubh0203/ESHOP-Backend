package com.Eshop.shop.validators;

import com.Eshop.shop.dtos.OrderDTO;
import com.Eshop.shop.exceptions.APIException;

import java.text.ParseException;

public interface OrderValidator {
    public void validateOrder(OrderDTO orderDTO) throws ParseException, APIException;
}
