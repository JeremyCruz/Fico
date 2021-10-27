package com.pe.fico.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pe.fico.entities.SavingAccountProduct;
import com.pe.fico.repositories.ISavingAccountProductRepository;
import com.pe.fico.service.ISavingAccountProductService;

@Service
public class SavingAccountProductImpl implements ISavingAccountProductService {
	
	@Autowired
	private ISavingAccountProductRepository sA;

	@Override
	public boolean insert(SavingAccountProduct SavingAccount) {
		SavingAccountProduct objSavingAccount = sA.save(SavingAccount);
		if (objSavingAccount == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<SavingAccountProduct> list() {
		return sA.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public SavingAccountProduct listarId(int idSavingAccount) {
		Optional<SavingAccountProduct> op = sA.findById(idSavingAccount);
		return op.isPresent() ? op.get() : new SavingAccountProduct();
	}
	

}
