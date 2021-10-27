package com.pe.fico.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pe.fico.entities.SavingAccountProduct;



public interface ISavingAccountProductRepository extends JpaRepository<SavingAccountProduct, Integer>{
	@Query("select count(sa.minOpeningSaving) from SavingAccountProduct sa where sa.idSavingAccount=:name")
	public int buscarCuentaAhorro(@Param("name") String nombre);
}
