package com.pe.fico.service;

import java.util.List;

import com.pe.fico.entities.LoanProduct;

public interface ILoanProductService {

	public boolean insert(LoanProduct loan);

	List<LoanProduct> list();

	LoanProduct listarId(int idLoan);
	
}
