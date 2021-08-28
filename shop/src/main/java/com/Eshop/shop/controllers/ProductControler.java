package com.Eshop.shop.controllers;

import com.Eshop.shop.dtos.ProductDTO;
import com.Eshop.shop.entitie.Product;
import com.Eshop.shop.exceptions.APIException;
import com.Eshop.shop.exceptions.BadCredentialsException;
import com.Eshop.shop.exceptions.ProductDetailsNotFoundException;
import com.Eshop.shop.exceptions.UserDetailsNotFoundException;
import com.Eshop.shop.services.ProductService;
import com.Eshop.shop.services.UserService;
import com.Eshop.shop.validators.ProductValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class ProductControler {
    @Autowired
    ProductService productService;
    @Autowired
    ProductValidator productValidator;
    @Autowired
    UserService userService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping(value = "/product/{id}")
    public ResponseEntity getproductDetails(@PathVariable(name = "id") int id) throws ProductDetailsNotFoundException {
        Product responseProduct = productService.getProductDetails(id);
        ProductDTO responseProductDTO = modelMapper.map(responseProduct,ProductDTO.class);
        return new ResponseEntity<>(responseProductDTO, HttpStatus.OK);
    }

    @PostMapping(value="/products",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newProduct(@RequestBody ProductDTO productDTO, @RequestHeader(value = "ACCESS-TOKEN") String token) throws APIException, BadCredentialsException, UserDetailsNotFoundException {
        if(token == null)
            throw new APIException("Please add proper authentication");
        if(!userService.getUserDetailsByUsername(token).getRole().equalsIgnoreCase("Admin"))
            throw new BadCredentialsException("This feature is only available to admin");
        Product newProduct = modelMapper.map(productDTO, Product.class);
        Product savedProduct = productService.acceptProductDetails(newProduct);
        ProductDTO savedProductDTO = modelMapper.map(savedProduct, ProductDTO.class);
        return new ResponseEntity<>(savedProductDTO, HttpStatus.CREATED);
    }
    @PutMapping(value="/products/{id}",consumes= MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
    public ResponseEntity updateProductDetails(@PathVariable(name = "id") int id, @RequestBody ProductDTO productDTO) throws APIException, ParseException,ProductDetailsNotFoundException {
        productValidator.validateProduct(productDTO);
        Product newMovie = modelMapper.map(productDTO, Product.class);
        Product updatedProduct = productService.updateProductDetails(id, newMovie);
        ProductDTO updatedProductDTO = modelMapper.map(updatedProduct, ProductDTO.class);
        return new ResponseEntity<>(updatedProductDTO,HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> removeProductDetails(@PathVariable("id") int id) throws  ProductDetailsNotFoundException {
        productService.deleteProduct(id);
        return new ResponseEntity<>("product details successfully removed ",HttpStatus.OK);
    }

    @GetMapping(value = "/products/categories")
    public ResponseEntity getcategoyList() throws ProductDetailsNotFoundException {
        List<String> list=productService.getallCategory();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
