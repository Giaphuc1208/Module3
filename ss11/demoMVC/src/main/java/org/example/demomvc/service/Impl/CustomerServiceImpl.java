package org.example.demomvc.service.Impl;

import org.example.demomvc.model.Customer;
import org.example.demomvc.service.CustomerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1,"Truong Hoi","truonghoi@codegym.com","QN"));
        customers.put(2, new Customer(2,"Van Sy","vansy@codegym.com","QN"));
        customers.put(3, new Customer(3,"Van Cuong","vancuong@codegym.com","QN"));
        customers.put(4, new Customer(4,"Duong Nhat","duongnhat@codegym.com","PY"));
        customers.put(5, new Customer(5,"Bao Ky","baoky@codegym.com","H"));
        customers.put(6, new Customer(6,"Hong Quang","hongquang@codegym.com","HT"));
        customers.put(7, new Customer(7,"Chi Thanh","chithanh@codegym.com","QB"));
        customers.put(8, new Customer(8,"Hoang Phong","hoangphong@codegym.com","H"));
        customers.put(9, new Customer(9,"Trung Hieu","trunghieu@codegym.com","QT"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
