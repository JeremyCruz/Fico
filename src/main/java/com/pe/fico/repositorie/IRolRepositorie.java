package pe.com.fico.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.fico.entities.Rol;

@Repository
public interface IRolRepositorie extends JpaRepository<Rol, Integer>{

	@Query("select count(c.idRol) from Roles c where c.idRol = :roles ")
	public int buscarRol(@Param("roles") Integer roles);
}
