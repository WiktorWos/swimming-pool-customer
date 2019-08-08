package com.poolcustomer.service;

import com.poolcustomer.dao.CustomerHistoryDAO;
import com.poolcustomer.entity.Customer;
import com.poolcustomer.entity.CustomerHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerHistoryServiceImpl implements CustomerHistoryService {
    @Autowired
    CustomerHistoryDAO customerHistoryDAO;

    @Override
    @Transactional
    public List<CustomerHistory> getCustomersHistory() {
        return customerHistoryDAO.getCustomersHistory();
    }

    @Override
    @Transactional
    public void saveCustomerHistory(CustomerHistory customerHistory) {
        customerHistoryDAO.saveCustomerHistory(customerHistory);
    }
}
