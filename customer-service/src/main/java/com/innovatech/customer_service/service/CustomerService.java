package com.innovatech.customer_service.service;

import java.util.List;

import com.innovatech.customer_service.model.Customer;
import com.innovatech.customer_service.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer findbyId(long id){
        return customerRepository.findById(id).get();
    }

    public Customer save(Customer costumer){
        return customerRepository.save(costumer);
    }

    public void delet(Long id){
        customerRepository.deleteById(id);
    }
}
