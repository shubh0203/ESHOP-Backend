package com.Eshop.shop.validators;

import com.Eshop.shop.dtos.OrderDTO;
import com.Eshop.shop.exceptions.APIException;
import com.Eshop.shop.utils.DateDifference;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;

@Service
public class OrderValidatorImp implements OrderValidator{
    @Override
    public void validateOrder(OrderDTO orderDTO) throws ParseException, APIException {
        if(orderDTO.getUderId() <= 0)
            throw new APIException("Invalid userId");
        if(orderDTO.getProductId() <= 0)
            throw new APIException("Invalid number of product");
        if(orderDTO.getAddressId() <= 0)
            throw new APIException("Invalid AddressID");
        int dateDifference = DateDifference.differenceBetweenDates(orderDTO.getDate(), LocalDateTime.now());
        if(dateDifference < 0 || dateDifference >= 3)
            throw new APIException("Invalid booking date");
    }
}
