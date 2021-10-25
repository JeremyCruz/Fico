package com.pe.fico.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.fico.entities.Institution;
import com.pe.fico.repositories.IInstitutionRepository;
import com.pe.fico.serviceinterfaces.IInstitutionService;

@Service
public class InstitutionServiceImplement implements IInstitutionService {
	@Autowired
	private IInstitutionRepository iR;
	@Override
	public Integer insert(Institution ins) {
		// TODO Auto-generated method stub
		int result = iR.buscarInstitucion(ins.getDInstitution());
		if (result == 0) {
			iR.save(ins);
		}
		return result;
	}

	@Override
	public List<Institution> list() {
		// TODO Auto-generated method stub
		return iR.findAll();
	}

}
