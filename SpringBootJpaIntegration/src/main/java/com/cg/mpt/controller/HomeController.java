package com.cg.mpt.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.beans.Customer;
import com.cg.exception.InvalidCustomerId;
import com.cg.exception.InvalidMobileNo;
import com.cg.service.ICustomerService;

@RestController
public class HomeController {

	@Autowired
	ICustomerService service;

	public ICustomerService getService() {
		return service;
	}

	public void setService(ICustomerService service) {
		this.service = service;
	}

//	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, produces = "application/json")
//	public Customer addCustomer(@RequestParam("fname") String firstname, @RequestParam("lname") String lastname,
//			@RequestParam("mobno") String mobno, @RequestParam("email") String email, @RequestParam("age") int age,
//			@RequestParam("city") String city) {
//		Customer customer = new Customer();
//		customer.setFirstName(firstname);
//		customer.setLastName(lastname);
//		customer.setAge(age);
//		customer.setCity(city);
//		customer.setEmail(email);
//		customer.setMobileNo(mobno);
//		service.addCustomer(customer);
//		return customer;
//
//	}
	@RequestMapping(method=RequestMethod.POST,value="/addCustomer",consumes="application/json",produces="application/json")
	public Customer addCustomer(@RequestBody Customer cust)
	{
		//Customer customer = new Customer();
		Customer t1=service.addCustomer(cust);
		return t1;
	}
	
	
	@RequestMapping(value="/updateCustomer",consumes="application/json",produces="application/json",method=RequestMethod.POST)
	public Customer updateCustomer(@RequestBody Customer customer)
	{
	 customer=service.updateCustomer(customer);
		return customer;
		
	}
	
	@RequestMapping(value="/deleteCustomer/{custId}",produces="application/json")
	public Customer deleteCustomer(@PathVariable int custId)
	{
		Customer customer =service.deleteCustomer(custId);
		return customer;
	}
	
	
	
	@RequestMapping(value="/getCustomerList",produces="application/json")
	public List<Customer> getCustomerList()
	{
		List<Customer> list=service.getCustomerList();
		return list;
	}
	
	@RequestMapping(value="/getCustomer/{custId}",produces="application/json")
	public Customer findCustomer(@PathVariable int custId)
	{
		Customer customer=service.findCustomer(custId);
		return customer;
	}
	
	
	//Exceptions
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Id does not exist.")
	@ExceptionHandler(InvalidCustomerId.class)

	public void handleOtherException()
	{
}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Mobile number Invalid")
	@ExceptionHandler(InvalidMobileNo.class)

	public void handleOther1Exception()
	{
}}
