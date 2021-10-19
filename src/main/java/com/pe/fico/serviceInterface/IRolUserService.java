package pe.com.fico.serviceInterface;

import java.util.List;

import pe.com.fico.entities.RolUser;

public interface IRolUserService {

	public Integer insert(RolUser ru);

	List<RolUser> list();
}