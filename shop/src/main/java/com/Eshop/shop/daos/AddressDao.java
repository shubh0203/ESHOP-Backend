package com.Eshop.shop.daos;

import com.Eshop.shop.entitie.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AddressDao extends JpaRepository<Address,Integer> {
    public Address findById(int id);
}
