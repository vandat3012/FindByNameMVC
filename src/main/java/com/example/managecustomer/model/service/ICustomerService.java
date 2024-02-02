package com.example.managecustomer.model.service;

import com.example.managecustomer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save (Customer customer);
    Customer findById (int id);
    void updateById (int id,Customer customer);
    void removeById (int id);
    List<Customer> findByName(String name);
}
