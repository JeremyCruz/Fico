package com.pe.fico.serviceinterfaces;

import java.util.List;

import com.pe.fico.entities.Institution;

public interface IInstitutionService {
	public Integer insert(Institution ins);

	List<Institution> list();
}
