package pe.com.fico.serviceInterface;

import java.util.List;

import pe.com.fico.entities.UserCenter;

public interface IUserCenterService {

	public Integer insert(UserCenter vc);

	public List<UserCenter> list();

}