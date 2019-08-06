package com.poolcustomer.dao;

import com.poolcustomer.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("from Customer",Customer.class);
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.format(date);
        customer.setStart(date);
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class,id);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Customer.class,id));
    }

    @Override
    public void boxIsEmpty(Customer customer, BindingResult bindingResult) {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("from Customer c where c.boxNumber=:customerBoxNumber",Customer.class);
        query.setParameter("customerBoxNumber",customer.getBoxNumber());
        if(!query.getResultList().isEmpty()) {
            bindingResult.addError(new ObjectError("boxNotEmpty","Box is already used"));
        }
    }
}
