package pe.com.fico.serviceInterface;

import java.util.List;
import java.util.Optional;

import pe.com.fico.entities.Rol;
import pe.com.fico.entities.User;
import pe.com.fico.entities.UserRol;

public interface IRolService {

	public Integer insert(Rol rol);

	public Integer update(Rol rol);

	public Integer delete(Rol rol);

	List<Rol> list();

	Optional<Rol> getOne(Rol rol);

	public Integer assignRolesToUser(User user, List<Rol> roles);

	List<UserRol> findUserRolesByUser(User user);
}