package com.Eshop.shop.services;

import com.Eshop.shop.entitie.User;
import com.Eshop.shop.exceptions.UserDetailsNotFoundException;
import com.Eshop.shop.exceptions.UserNameAlreadyExistException;
import com.Eshop.shop.exceptions.UserTypeDetailsNotFoundException;

public interface UserService {

    public User acceptUserDetails(User user) throws UserNameAlreadyExistException, UserTypeDetailsNotFoundException;
    public User getUserDetails(int id) throws UserDetailsNotFoundException;
    public User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException;
    public User updateUserDetails(int id, User user) throws UserNameAlreadyExistException, UserDetailsNotFoundException, UserTypeDetailsNotFoundException;

}
