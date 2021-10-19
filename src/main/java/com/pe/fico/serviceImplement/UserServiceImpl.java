package pe.com.fico.serviceImplement;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import pe.com.fico.entities.User;
import pe.com.fico.repositorie.IUserRepositorie;
import pe.com.fico.serviceInterface.IUserService;

@Service
@RequestScope
public class UserServiceImpl implements IUserService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IUserRepositorie uD;

	@Override
	public Integer insert(User user) {
		int rpta = uD.buscarUserRoles(user.getIdUserCenter());
		if(rpta == 0) {
			uD.save(user);
		}
		return rpta;
	}

	@Override
	public List<User> list() {
		return uD.findAll();
	}
	
	
	//FALTA COMPLETAR
	@Override
	public Integer update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getOne(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> authentication(User us) {
		// TODO Auto-generated method stub
		return null;
	}

	

}