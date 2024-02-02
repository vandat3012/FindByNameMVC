package com.example.managecustomer.model.service;

import com.example.managecustomer.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private static Map<Integer,Customer> customerMap = new HashMap<>();
    static {
        customerMap.put(1,new Customer(1,"d","dat@gmail.com","HT"));
        customerMap.put(2,new Customer(2,"Đăng Pháp","phap@gmail.com","QT"));
        customerMap.put(3,new Customer(3,"Hải Nhật","nhat@gmail.com","QT"));
        customerMap.put(4,new Customer(4,"Thanh Dụng","dung@gmail.com","QN"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }

    @Override
    public void updateById(int id, Customer customer) {
        customerMap.put(id,customer);
    }

    @Override
    public void removeById(int id) {
        customerMap.remove(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = new ArrayList<>();
        for (Integer key: customerMap.keySet()) {
            if (customerMap.get(key).getName().equals(name)){
                customers.add(customerMap.get(key));
            }
        }
        return customers;
    }
}
