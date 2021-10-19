package pe.com.fico.serviceImplement;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.fico.entities.Rol;
import pe.com.fico.serviceInterface.IRolService;
import pe.com.fico.entities.User;
import pe.com.fico.entities.UserRol;
import pe.com.fico.repositorie.IRolRepositorie;

@Service
public class RolServiceImpl implements IRolService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IRolRepositorie rD;

	@Override
	public Integer insert(Rol rol) {
		int rpta = rD.buscarRol(rol.getIdRol());
		if(rpta == 0) {
			rD.save(rol);
		}
		return rpta;
	}
	
	@Override
	public List<Rol> list() {
		return rD.findAll();
	}
	
	
	
	
	//FALTA COMPLETAR
	@Override
	public Integer update(Rol rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Rol rol) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<Rol> getOne(Rol rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer assignRolesToUser(User user, List<Rol> roles) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRol> findUserRolesByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	


}