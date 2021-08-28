package com.Eshop.shop.validators;

import com.Eshop.shop.dtos.AddressDTO;
import com.Eshop.shop.dtos.OrderDTO;
import com.Eshop.shop.exceptions.APIException;

import java.text.ParseException;

public interface AddressValidator {
    public void validateAddress(AddressDTO addressDTO) throws ParseException, APIException;
}
