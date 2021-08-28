package com.Eshop.shop.validators;

import com.Eshop.shop.dtos.LoginDTO;
import com.Eshop.shop.dtos.UserDTO;
import com.Eshop.shop.exceptions.APIException;

public interface UserValidator {
    public void validateUser(UserDTO userDTO) throws APIException;
    public void validateUserLogin(LoginDTO loginDTO) throws APIException;
}
