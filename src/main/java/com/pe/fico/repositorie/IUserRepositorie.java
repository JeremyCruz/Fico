package pe.com.fico.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.fico.entities.User;

@Repository
public interface IUserRepositorie extends JpaRepository<User, Integer>{

	@Query("select count(c.id) from User_Roles c where c.id = :id ")
	public int buscarUserRoles(@Param("id") Integer id);
}
