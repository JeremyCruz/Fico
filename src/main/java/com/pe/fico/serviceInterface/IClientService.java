package pe.com.fico.serviceInterface;

import java.util.List;
import java.util.Optional;

import pe.com.fico.entities.Customer;

public interface IClientService {

	public Integer insert(Customer customer);

	public Integer update(Customer customer);

	public Integer delete(Customer customer);

	List<Customer> list();

	Optional<Customer> getOne(Customer customer);

	List<Customer> findCustomerByName(String name);

	Optional<Customer> findCustomerByDni(String dni);
}
