package com.Eshop.shop.validators;

import com.Eshop.shop.dtos.ProductDTO;
import com.Eshop.shop.exceptions.APIException;
import com.Eshop.shop.utils.DateDifference;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;

@Service
public class ProductValidoterImp implements ProductValidator{
    @Override
    public void validateProduct(ProductDTO productDTO) throws ParseException, APIException {
        if(productDTO.getName() != null)
            throw new APIException("Invalid product name");
        if(productDTO.getPrice() <= 0)
            throw new APIException("Invalid product price");
        if(productDTO.getCategory() != null)
            throw new APIException("Invalid product category");
        if(productDTO.getAvelabilty() != null)
            throw new APIException("Invalid avlability");
        if(productDTO.getManufacture() != null)
            throw new APIException("Invalid manfacture");
        int dateDifference = DateDifference.differenceBetweenDates(productDTO.getCreated(), LocalDateTime.now());
        if(dateDifference < 0 || dateDifference >= 3)
            throw new APIException("Invalid booking date");
    }
}
