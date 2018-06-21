package com.duduanan.crm.dao;

import java.util.List;

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
	@Override
	public List<Customer> getCustomers() {
		Session session=sessionfactory.getCurrentSession();
		Query<Customer> query=session.createQuery("from Customer",Customer.class);    	
		List<Customer> list=query.getResultList();
		return list;
	}
	@Override
	public void saveCustomer(Customer theCustomer) {
	   Session session=sessionfactory.getCurrentSession();
	   session.saveOrUpdate(theCustomer);
	}
	@Override
	public Customer getCustomer(int theId) {
		Session session=sessionfactory.getCurrentSession();
		 return session.get(Customer.class, theId);
	}
	@Override
	public void deleteCustomer(int theId) {
	   Session session=sessionfactory.getCurrentSession();	 
	   @SuppressWarnings("rawtypes")
	   Query theQuery=session.createQuery("delete from Customer where id=:customerId");
	   theQuery.setParameter("customerId", theId);
	   theQuery.executeUpdate();		
	}
	@Override
	public List<Customer> searchCustomer(String theSearchName) {
		Session session=sessionfactory.getCurrentSession();
		Query<Customer> query=null;
		if(theSearchName!=null&&theSearchName.trim().length()>0){
			query=session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName",Customer.class);
			query.setParameter("theName", "%"+theSearchName+"%");
		}else{
			query=session.createQuery("from Customer", Customer.class);
		}   
		return query.getResultList();
	}

}
