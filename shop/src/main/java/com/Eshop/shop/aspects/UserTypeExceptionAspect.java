package com.Eshop.shop.aspects;

import com.Eshop.shop.exceptions.UserTypeDetailsNotFoundException;
import com.Eshop.shop.utils.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserTypeExceptionAspect {
    @ExceptionHandler(UserTypeDetailsNotFoundException.class)
    public ResponseEntity<CustomResponse> handleUserTypeDetailsNotFoundException(Exception e){
        CustomResponse response = new CustomResponse(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return  new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }
}
