package pe.com.fico.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.fico.entities.RolUser;

@Repository
public interface IRolUserRepositorie extends JpaRepository<RolUser, Integer>{

	@Query("select count(c.nameRolUser) from RolUser c where c.nameRolUser = :rolUser ")
	public int buscarRolUser(@Param("rolUser") String rolUser);
}
