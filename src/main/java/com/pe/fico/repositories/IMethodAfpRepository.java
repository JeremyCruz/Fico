package com.pe.fico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pe.fico.entities.MethodComitionAFP;

public interface IMethodAfpRepository  extends JpaRepository<MethodComitionAFP, Integer>{

	@Query("select count(c.nameMethodAFP) from MethodComitionAFP c where c.nameMethodAFP=:clave")
	public int searchMethod(@Param("clave") String name);
}
