package com.Eshop.shop.daos;

import com.Eshop.shop.entitie.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    public User findByusername(String username);
    public User findById(int id);
    public User findByUsername(String username);

}
