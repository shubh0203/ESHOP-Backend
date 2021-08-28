package com.Eshop.shop.validators;

import com.Eshop.shop.dtos.LoginDTO;
import com.Eshop.shop.dtos.UserDTO;
import com.Eshop.shop.exceptions.APIException;
import org.springframework.stereotype.Service;

@Service
public class UserValidatorImp implements UserValidator{
    @Override
    public void validateUser(UserDTO userDTO) throws APIException {
        if(userDTO.getUsername() == null || userDTO.getUsername().length() <= 0)
            throw new APIException("Invalid username");
        if(userDTO.getFirstName() == null || userDTO.getFirstName().length() <= 0 )
            throw new APIException("Invalid firstname");
        if(userDTO.getLastName() == null || userDTO.getLastName().length() <= 0 )
            throw new APIException("Invalid lastname");
        if(userDTO.getPassword() == null || userDTO.getPassword().length() <= 0   )
            throw new APIException("Invalid password");
        if(userDTO.getCreated() == null)
            throw new APIException("Invalid date of birth");
        if(userDTO.getRole() == "Admin" || userDTO.getRole() == "User")
            throw new APIException("Invalid user type");
    }

    @Override
    public void validateUserLogin(LoginDTO user) throws APIException {
        if (user.getUsername() == null || user.getUsername().length() <= 0) {
            throw new APIException("Invalid username");
        }
        if(user.getPassword() == null || user.getPassword().length() <= 0   ) {
            throw new APIException("Invalid password");
        }
    }
}
