package com.Eshop.shop.services;

import com.Eshop.shop.entitie.Address;
import com.Eshop.shop.entitie.Product;
import com.Eshop.shop.exceptions.AddressDetailsNotFoundException;
import com.Eshop.shop.exceptions.ProductDetailsNotFoundException;

public interface AddressService {
    public Address acceptAddressDetails(Address address);
    public Address getAddressDetails(int id) throws AddressDetailsNotFoundException;
    public Address updateAddressDetails(int id, Address address) throws AddressDetailsNotFoundException;
    public boolean deleteAddress(int id) throws AddressDetailsNotFoundException ;
}
