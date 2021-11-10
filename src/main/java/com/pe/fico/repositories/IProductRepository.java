package com.pe.fico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.fico.entities.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
	@Query("select count(l.nameProduct) from Product l where l.nameProduct=:name")
	public int buscarProducto(@Param("name") String nombre);
}
