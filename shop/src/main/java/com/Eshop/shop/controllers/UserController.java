package com.Eshop.shop.controllers;

import com.Eshop.shop.dtos.UserDTO;
import com.Eshop.shop.entitie.User;
import com.Eshop.shop.exceptions.APIException;
import com.Eshop.shop.exceptions.UserDetailsNotFoundException;
import com.Eshop.shop.services.UserService;
import com.Eshop.shop.validators.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ReadingConverter
@RequestMapping(value = "/users/details")
public class UserController {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserService customerService;
    @Autowired
    UserValidator customerValidator;

    @GetMapping(value="/details/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCustomerDetails(@PathVariable(name = "id") int id ) throws  APIException, UserDetailsNotFoundException {
        User newuser=customerService.getUserDetails(id);
        UserDTO currentUserDTO = modelMapper.map(newuser, UserDTO.class);
        return new ResponseEntity<>(currentUserDTO, HttpStatus.OK);
    }
}
