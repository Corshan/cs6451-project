package com.cnkl.fems.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @GetMapping
    public List<Customers> getAllCustomers(){
        return customersService.getAllCustomers();
    }
}
