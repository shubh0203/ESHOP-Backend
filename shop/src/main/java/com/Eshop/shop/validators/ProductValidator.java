package com.Eshop.shop.validators;

import com.Eshop.shop.dtos.OrderDTO;
import com.Eshop.shop.dtos.ProductDTO;
import com.Eshop.shop.exceptions.APIException;

import java.text.ParseException;

public interface ProductValidator {
    public void validateProduct(ProductDTO productDTO) throws ParseException, APIException;
}
