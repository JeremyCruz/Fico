package pe.com.fico.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.fico.entities.Customer;

@Repository
public interface IClientRepositorie extends JpaRepository<Customer, Integer>{

	@Query("select count(c.nameClient) from Customers c where c.nameClient = :name ")
	public int buscarClient(@Param("name") String name);
	  
}
