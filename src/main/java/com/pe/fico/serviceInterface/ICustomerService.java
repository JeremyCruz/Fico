package com.pe.fico.serviceInterface;

import java.util.List;

import com.pe.fico.entities.Customer;

public interface ICustomerService {

	public boolean insert(Customer customer);
	
	public Integer insertDni(Customer customer);
	
	List<Customer> list();
	
	Customer listarId(int idCustomer);
}
