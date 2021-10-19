package pe.com.fico.serviceImplement;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import pe.com.fico.entities.RolUser;
import pe.com.fico.repositorie.IRolUserRepositorie;
import pe.com.fico.serviceInterface.IRolUserService;

@Service
@RequestScope
public class RolUserServiceImpl implements IRolUserService {

	@Autowired
	private IRolUserRepositorie ruD;

	@Override
	public Integer insert(RolUser ru) {
		int rpta = ruD.buscarRolUser(ru.getNameRolUser());
		if(rpta == 0) {
			ruD.save(ru);
		}
		return rpta;
	}

	@Override
	public List<RolUser> list() {

		return ruD.findAll();
	}

}