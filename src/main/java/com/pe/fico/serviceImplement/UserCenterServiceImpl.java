package pe.com.fico.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;


import pe.com.fico.entities.UserCenter;
import pe.com.fico.repositorie.IUserCenterRepositorie;
import pe.com.fico.serviceInterface.IUserCenterService;

@Service
@RequestScope
public class UserCenterServiceImpl implements IUserCenterService {

	@Autowired
	private IUserCenterRepositorie vD;

	@Override
	public Integer insert(UserCenter vc) {
		int rpta = vD.buscarUserCenter(vc.getNameUserCenter());
		if(rpta == 0) {
			vD.save(vc);
		}
		return rpta;

	}

	@Override
	public List<UserCenter> list() {
		return vD.findAll();
	}

}