package com.pe.fico.service;

import java.util.List;

import com.pe.fico.entities.SavingAccountProduct;
public interface ISavingAccountProductService {
	public boolean insert(SavingAccountProduct idSavingAccount);

	List<SavingAccountProduct> list();

	SavingAccountProduct listarId(int idSavingAccount);
}
