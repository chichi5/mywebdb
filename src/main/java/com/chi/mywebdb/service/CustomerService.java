package com.chi.mywebdb.service;

import com.chi.mywebdb.mapper.CustomerMapper;
import com.chi.mywebdb.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    JdbcTemplate jdbcTemplate;

    public List<Customer> getCustomerAll() {
        CustomerMapper cmapper = new CustomerMapper();
        // jdbcTemplate 負責 迴圈(rs.next) 跟蒐集(List)
        List<Customer> allcustomer = jdbcTemplate.query("select * from customers", cmapper);
        return allcustomer;
    }
}
