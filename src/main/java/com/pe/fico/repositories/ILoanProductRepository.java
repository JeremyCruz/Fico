package com.pe.fico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.fico.entities.LoanProduct;

public interface ILoanProductRepository extends JpaRepository<LoanProduct, Integer> {

}
