package com.Eshop.shop.controllers;

import com.Eshop.shop.dtos.LoginDTO;
import com.Eshop.shop.dtos.UserDTO;
import com.Eshop.shop.entitie.User;
import com.Eshop.shop.exceptions.*;
import com.Eshop.shop.services.UserService;
import com.Eshop.shop.services.UserServiceImp;
import com.Eshop.shop.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;
import java.util.HashMap;
import java.util.Map;

@RestController

public class AuthController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserService customerService;
    @Autowired
    UserValidator customerValidator;

    @PostMapping(value = "/auth/register",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity signup(@RequestBody UserDTO userDTO)
            throws APIException,UserNameAlreadyExistException, UserDetailsNotFoundException, CustomException {

        customerValidator.validateUser(userDTO);
        try {
            User customer = customerService.getUserDetailsByUsername(userDTO.getUsername());
            if (customer != null && customer.getFirstname()!=null) {
                throw new UserNameAlreadyExistException(
                        "Customer username name can't blank already exists for : " + customer.getUsername());
            }
        } catch (UserDetailsNotFoundException | UserNameAlreadyExistException ex) {
            System.out.println("Customer does not exist for the given details");
        }

        try {
            User customer = customerService.getUserDetailsByUsername(userDTO.getUsername());

            if (customer.getPhoneNumbers() != null && customer.getPhoneNumbers().length()==10) {
                throw new UserNameAlreadyExistException(
                        "please enter valid mobil nomber : " + customer.getPhoneNumbers());
            }
        } catch (UserDetailsNotFoundException | UserNameAlreadyExistException ex) {
            System.out.println("Customer does not exist for the given details");
        }
        try {
            User customer = customerService.getUserDetailsByUsername(userDTO.getUsername());

            if (customer.getEmail() != null && customer.getEmail().contains("@gmail.com")==true) {
                throw new UserNameAlreadyExistException(
                        "please enter valid gmail id : " + customer.getPhoneNumbers());
            }
        } catch (UserDetailsNotFoundException | UserNameAlreadyExistException ex) {
            System.out.println("Customer does not exist for the given details");
        }
        try {
            Map<String, String> model = new HashMap<>();
            String username = userDTO.getUsername();
            String password = userDTO.getPassword();
            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                model.put("Error", "Username is invalid/ Password is empty");
                return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
            }
            User newCustomer = modelMapper.map(userDTO,User.class);
            User savedCustomer = customerService.acceptUserDetails(newCustomer);
            UserDTO savedCustomerDTO = modelMapper.map(savedCustomer,UserDTO.class);
            return new ResponseEntity<>(savedCustomerDTO,HttpStatus.CREATED);
        } catch (Exception e) {
            throw new CustomException("Username " + userDTO.getUsername() + " already registered",
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PostMapping(value = "/auth/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO)
            throws APIException, UserDetailsNotFoundException, CustomException, BadCredentialsException {
        customerValidator.validateUserLogin(loginDTO);
        Map<String, String> model = new HashMap<>();
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.put("Error", "Username is invalid/ Password is empty");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }
        User savedCustomer = customerService.getUserDetailsByUsername(username);
        if (!savedCustomer.getPassword().equals(password)) {
            throw new BadCredentialsException("Invalid username/password");
        }
        model.put("message","Logged in Successfully");
        model.put("token",savedCustomer.getUsername());
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
