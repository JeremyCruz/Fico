package com.pe.fico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.fico.entities.AfpProduct;

public interface IAfpProductRepository extends JpaRepository<AfpProduct, Integer>{

}
