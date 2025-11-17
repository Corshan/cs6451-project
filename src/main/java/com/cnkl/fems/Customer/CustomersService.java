package com.cnkl.fems.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    private CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }

    public Optional<Customers> getCustomerById(Long id) {
        return customersRepository.findById(id);
    }

    public Customers createCustomer(Customers customer) {
        return customersRepository.save(customer);
    }

    public void deleteCustomerById(Long id) {
        customersRepository.deleteById(id);
    }
}
