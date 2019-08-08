package com.poolcustomer.dao;

import com.poolcustomer.entity.Customer;
import com.poolcustomer.entity.CustomerHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerHistoryDAOImpl implements CustomerHistoryDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<CustomerHistory> getCustomersHistory() {
        Session session = sessionFactory.getCurrentSession();
        Query<CustomerHistory> query = session.createQuery("from CustomerHistory",CustomerHistory.class);
        return query.getResultList();
    }

    @Override
    public void saveCustomerHistory(CustomerHistory customerHistory) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customerHistory);
    }
}
