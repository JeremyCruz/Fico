package com.pe.fico.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pe.fico.entities.Customer;
import com.pe.fico.repositorie.CustomerRepositorie;
import com.pe.fico.serviceInterface.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private CustomerRepositorie cR;

	@Override
	public boolean insert(Customer customer) {
		Customer objCustomer = cR.save(customer);
		if (objCustomer == null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public List<Customer> list() {
		return cR.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Customer listarId(int idCustomer) {
		Optional<Customer> op = cR.findById(idCustomer);
		return op.isPresent() ? op.get() : new Customer();
	}

	@Override
	public Integer insertDni(Customer customer) {
		int rpta = cR.buscarDNI(customer.getDniCustomer());
		if(rpta == 0) {
			cR.save(customer);
		}
		return rpta;
	}

	@Override
	public void delete(int id) {
		cR.deleteById(id);
		
	}

}
