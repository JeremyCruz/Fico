package pe.com.fico.serviceInterface;

import java.util.List;
import java.util.Optional;

import pe.com.fico.entities.User;

public interface IUserService {
	public Integer insert(User user);

	public Integer update(User user);

	public Integer delete(User user);

	List<User> list();

	Optional<User> getOne(User user);

	Optional<User> authentication(User us);
}