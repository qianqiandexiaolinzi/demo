package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vickl on 2018/12/4.
 */
public interface CustomerDao extends CrudRepository<Customer,Integer>{
    Customer save(Customer customer);
}
