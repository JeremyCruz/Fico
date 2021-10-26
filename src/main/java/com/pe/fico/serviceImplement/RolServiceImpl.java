package com.pe.fico.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.fico.entities.Rol;
import com.pe.fico.repositorie.RolRepositorie;
import com.pe.fico.serviceInterface.IRolService;

@Service
public class RolServiceImpl implements IRolService{

	@Autowired
	private RolRepositorie rR;

	@Override
	public Integer insert(Rol rol) {
		int rpta = rR.buscarRol(rol.getTypeRol());
		if(rpta == 0) {
			rR.save(rol);
		}
		return rpta;
	}

	@Override
	public List<Rol> list() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}
	
}
