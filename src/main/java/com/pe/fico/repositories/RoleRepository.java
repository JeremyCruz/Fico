package com.pe.fico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.fico.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}