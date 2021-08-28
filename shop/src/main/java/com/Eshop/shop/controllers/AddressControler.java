package com.Eshop.shop.controllers;

import com.Eshop.shop.dtos.AddressDTO;
import com.Eshop.shop.entitie.Address;
import com.Eshop.shop.exceptions.APIException;
import com.Eshop.shop.exceptions.UserDetailsNotFoundException;
import com.Eshop.shop.services.AddressService;
import com.Eshop.shop.services.UserService;
import com.Eshop.shop.validators.AddressValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressControler {
    @Autowired
    AddressValidator addressValidator;
    @Autowired
    AddressService addressService;
    @Autowired
    UserService userService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping(value="/user-address",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newAddress(@RequestBody AddressDTO addressDTO, @RequestHeader(value = "ACCESS-TOKEN") String token) throws APIException, UserDetailsNotFoundException {
        if(token == null)
            throw new APIException("Please add proper authentication");

        Address newaddress = modelMapper.map(addressDTO, Address.class);
        Address savedAddress = addressService.acceptAddressDetails(newaddress);
        AddressDTO savedAddressDTO = modelMapper.map(savedAddress, AddressDTO.class);
        return new ResponseEntity<>(savedAddressDTO, HttpStatus.CREATED);
    }
}
