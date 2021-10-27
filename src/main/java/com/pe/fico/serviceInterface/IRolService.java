package com.pe.fico.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.pe.fico.entities.Rol;

public interface IRolService {

	public Integer insert(Rol rol);
	
	public void delete(int id);
	
	List<Rol> list();
	
	Optional<Rol> listarId(int id);
}
