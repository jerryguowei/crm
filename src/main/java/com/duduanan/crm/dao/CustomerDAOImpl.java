package com.duduanan.crm.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duduanan.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionfactory;
    @Transactional
	@Override
	public List<Customer> getCustomers() {
		Session session=sessionfactory.getCurrentSession();
		Query<Customer> query=session.createQuery("from Customer",Customer.class);    	
		List<Customer> list=query.getResultList();
		return list;
	}

}
