package com.poolcustomer.service;

import com.poolcustomer.entity.Customer;
import com.poolcustomer.entity.CustomerHistory;

import java.util.List;

public interface CustomerHistoryService {
    public List<CustomerHistory> getCustomersHistory();
    public void saveCustomerHistory(CustomerHistory customerHistory);
}
