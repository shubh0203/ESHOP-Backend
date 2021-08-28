package com.Eshop.shop.aspects;

import com.Eshop.shop.exceptions.BadCredentialsException;
import com.Eshop.shop.utils.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BadCredentialsExceptionAspect {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<CustomResponse> badCredentialsException(Exception e){
        CustomResponse response = new CustomResponse(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return  new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }
}
