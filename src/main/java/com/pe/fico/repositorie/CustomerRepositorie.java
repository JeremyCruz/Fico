package com.pe.fico.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.fico.entities.Customer;

@Repository
public interface CustomerRepositorie extends JpaRepository<Customer, Integer>{

	@Query("select count(c.dniCustomer) from Customer c where c.dniCustomer = :name ")
	public int buscarDNI(@Param("name") String name);
}
