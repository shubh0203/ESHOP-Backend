package com.Eshop.shop.services;

import com.Eshop.shop.daos.UserDao;
import com.Eshop.shop.entitie.User;
import com.Eshop.shop.exceptions.UserDetailsNotFoundException;
import com.Eshop.shop.exceptions.UserNameAlreadyExistException;
import com.Eshop.shop.exceptions.UserTypeDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    public UserDao userDao;

    @Override
    public User acceptUserDetails(User user) throws UserNameAlreadyExistException, UserTypeDetailsNotFoundException {
        return userDao.save(user);
    }

    @Override
    public User getUserDetails(int id) throws UserDetailsNotFoundException {
        return userDao.findById(id);
    }

    @Override
    public User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException {
        return userDao.findByUsername(username);
    }

    @Override
    public User updateUserDetails(int id, User user) throws UserNameAlreadyExistException, UserDetailsNotFoundException, UserTypeDetailsNotFoundException {
        User newuser=getUserDetails(id);
        if (isNotNullOrZero(user.getFirstname())) {
            newuser.setFirstname(user.getFirstname());
        }
        if (isNotNullOrZero(user.getLastName())) {
            newuser.setLastName(user.getLastName());
        }
        if (isNotNullOrZero(user.getCreated())) {
            newuser.setCreated(user.getCreated());
        }
        if (isNotNullOrZero(user.getUpdated())) {
            newuser.setUpdated(user.getUpdated());
        }
        if (isNotNullOrZero(user.getEmail())) {
            newuser.setEmail(user.getEmail());
        }
        if (isNotNullOrZero(user.getUsername())) {
            newuser.setUsername(user.getUsername());
        }
        if (isNotNullOrZero(user.getPassword())) {
            newuser.setFirstname(user.getPassword());
        }
        if (isNotNullOrZero(user.getPhoneNumbers())) {
            newuser.setPhoneNumbers(user.getPhoneNumbers());
        }
        if (isNotNullOrZero(user.getRole())) {
            newuser.setRole(user.getRole());
        }
        return null;
    }
    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }
}
