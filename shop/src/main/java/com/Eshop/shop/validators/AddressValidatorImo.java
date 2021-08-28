package com.Eshop.shop.validators;

import com.Eshop.shop.dtos.AddressDTO;
import com.Eshop.shop.exceptions.APIException;
import com.Eshop.shop.utils.DateDifference;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;

@Service
public class AddressValidatorImo implements AddressValidator{
    @Override
    public void validateAddress(AddressDTO addressDTO) throws ParseException, APIException {
        if(addressDTO.getId() <= 0)
            throw new APIException("Invalid userId");
        if(addressDTO.getLandmark() != null)
            throw new APIException("Invalid landmark of address");
        if(addressDTO.getCity() != null)
            throw new APIException("Invalid city");
        if(addressDTO.getName() != null)
            throw new APIException("Invalid name");
        if(addressDTO.getPhone() != null)
            throw new APIException("Invalid number");
        if(addressDTO.getStreet() != null)
            throw new APIException("Invalid street");
        if(addressDTO.getState() != null)
            throw new APIException("Invalid state");
        if(addressDTO.getZipcode() != null)
            throw new APIException("Invalid zipcode");

    }
}
