package com.pe.fico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.fico.entities.CreditCardProduct;

public interface ICreditCardProductRepository extends JpaRepository<CreditCardProduct, Integer> {

}
