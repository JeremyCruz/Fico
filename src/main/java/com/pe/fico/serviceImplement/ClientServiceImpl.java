package pe.com.fico.serviceImplement;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.fico.entities.Customer;
import pe.com.fico.repositorie.IClientRepositorie;
import pe.com.fico.serviceInterface.IClientService;


@Service
public class ClientServiceImpl implements IClientService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IClientRepositorie cD;

	@Override
	public Integer insert(Customer customer){
		int rpta = cD.buscarClient(customer.getName());
		if(rpta == 0) {
			cD.save(customer);
		}
		return rpta;
	}

	@Override
	public List<Customer> list(){
		return cD.findAll();
	}

	
	
	
	
	//FALTA COMPLETAR

	@Override
	public Integer update(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer delete(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<Customer> getOne(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Customer> findCustomerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<Customer> findCustomerByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}


}