package com.Eshop.shop.services;

import com.Eshop.shop.daos.AddressDao;
import com.Eshop.shop.entitie.Address;
import com.Eshop.shop.entitie.Product;
import com.Eshop.shop.exceptions.AddressDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImp implements AddressService{
   //@Autowired
    public AddressDao addressDao;

    @Override
    public Address acceptAddressDetails(Address address) {
        return addressDao.save(address);
    }

    @Override
    public Address getAddressDetails(int id) throws AddressDetailsNotFoundException {
        return addressDao.findById(id);
    }

    @Override
    public Address updateAddressDetails(int id, Address address) throws AddressDetailsNotFoundException {
        Address savedAddress = getAddressDetails(id);
        savedAddress.setId(id);
        savedAddress.setLandmark(address.getLandmark());
        savedAddress.setCity(address.getCity());
        savedAddress.setName(address.getName());
        savedAddress.setPhone(address.getPhone());
        savedAddress.setState(address.getState());
        savedAddress.setStreet(address.getStreet());
        savedAddress.setZipcode(address.getZipcode());
        savedAddress.setUser(address.getUser());
        acceptAddressDetails(savedAddress);
        return savedAddress;
    }

    @Override
    public boolean deleteAddress(int id) throws AddressDetailsNotFoundException {
        Address address=getAddressDetails(id);
        addressDao.delete(address);
        return true;
    }
}
