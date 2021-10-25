package com.pe.fico.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.fico.entities.Institution;

@Repository
public interface IInstitutionRepositorie extends JpaRepository<Institution, Integer> {
	@Query("select count(ins.nameInstitution) from Institution ins where ins.nameInstitution=:name")
	public int buscarInstitucion(@Param("name") String nombre);
}
