package com.poolcustomer.dao;

import com.poolcustomer.entity.Customer;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);
    public Customer getCustomer(int id);
    public Customer getCustomerForCheckout(int boxNumber);
    public void deleteCustomer(int id);
    public boolean boxIsEmpty(Customer customer, BindingResult bindingResult);
}
