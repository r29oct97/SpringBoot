package com.cg.repos;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.beans.Customer;
import com.cg.exception.InvalidCustomerId;
@Repository("repo")
@Transactional
public class CustomerRepositoryImpl implements ICustomerRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public Customer addCustomer(Customer customer) {
		
		
		entityManager.persist(customer);
		//entityManager.getTransaction().commit();
		
		return customer;
	}
	@Override
	public Customer findCustomer(int customerid) {
		Customer customer= 
				entityManager.find(Customer.class, customerid);
		if(customer==null)
			throw new InvalidCustomerId();
/*			customer.setCustomerId(customerid);*/
		return customer;
	}
	@Override
	public Customer updateCustomer(Customer customer) {
		//entityManager.getTransaction().begin();
		entityManager.merge(customer);
		//entityManager.getTransaction().commit();
		return customer;
	}
	@Override
	public List<Customer> getCustomerList() {
		TypedQuery<Customer> query=
	entityManager.createQuery
	("select customer from Customer customer ", Customer.class);
			
		List<Customer> list= query.getResultList();
	return list;
	}
	@Override
	public Customer removeCustomer(int custid) {
		Customer customer= entityManager.find(Customer.class, custid);
		//entityManager.getTransaction().begin();
		entityManager.remove(customer);
		//entityManager.getTransaction().commit();
		return customer;
	}

}
