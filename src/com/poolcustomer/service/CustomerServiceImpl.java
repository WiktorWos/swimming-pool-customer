package com.poolcustomer.service;

import com.poolcustomer.dao.CustomerDAO;
import com.poolcustomer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    @Override
    @Transactional
    public boolean boxIsEmpty(Customer customer, BindingResult bindingResult) {
        return customerDAO.boxIsEmpty(customer,bindingResult);
    }

    @Override
    @Transactional
    public Customer getCustomerForCheckout(int boxNumber) {
        return customerDAO.getCustomerForCheckout(boxNumber);
    }
}
