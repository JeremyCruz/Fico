package com.pe.fico.service;

import java.util.List;

import com.pe.fico.entities.CreditCardProduct;

public interface ICreditCardProductService {

	public boolean insert(CreditCardProduct product);

	List<CreditCardProduct> list();

	CreditCardProduct listarId(int idProducto);
	
}
