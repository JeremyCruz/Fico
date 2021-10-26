package com.pe.fico.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.fico.entities.Rol;

@Repository
public interface RolRepositorie extends JpaRepository<Rol, Integer>{

	@Query("select count(c.typeRol) from Rol c where c.typeRol = :name ")
	public int buscarRol(@Param("name") String name);
}
