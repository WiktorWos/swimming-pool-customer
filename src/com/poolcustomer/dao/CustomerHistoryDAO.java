package com.poolcustomer.dao;

import com.poolcustomer.entity.Customer;
import com.poolcustomer.entity.CustomerHistory;

import java.util.List;

public interface CustomerHistoryDAO {
    public List<CustomerHistory> getCustomersHistory();
    public void saveCustomerHistory(CustomerHistory customerHistory);
}
