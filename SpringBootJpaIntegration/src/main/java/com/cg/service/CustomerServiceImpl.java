package com.cg.service;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.beans.Customer;
import com.cg.exception.InvalidMobileNo;
import com.cg.repos.ICustomerRepository;
@Service("service")
@Transactional
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	ICustomerRepository repo;	
	public ICustomerRepository getRepo() {
		return repo;
	}
	public void setRepo(ICustomerRepository repo) {
		this.repo = repo;
	}
	@Override
	public Customer addCustomer(Customer customer) {
		//exception
		String mobno=customer.getMobileNo();
Pattern pat= Pattern.compile("^[0-9]{10}$");
Matcher mat= pat.matcher(mobno);

		if(mat.matches()==false)
			throw new InvalidMobileNo();
		
		return repo.addCustomer(customer);
	}
	@Override
	public Customer findCustomer(int customerid) {
		return repo.findCustomer(customerid);
	}
	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repo.updateCustomer(customer);
	}
	@Override
	public List<Customer> getCustomerList() {
		return repo.getCustomerList();
	}
	@Override
	public Customer deleteCustomer(int custId) {
		// TODO Auto-generated method stub
		return repo.removeCustomer(custId);
	}
}
