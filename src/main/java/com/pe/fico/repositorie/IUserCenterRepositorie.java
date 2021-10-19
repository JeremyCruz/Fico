package pe.com.fico.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.fico.entities.UserCenter;

@Repository
public interface IUserCenterRepositorie extends JpaRepository<UserCenter, Integer>{

	@Query("select count(c.nameUserCenter) from UserCenter c where c.nameUserCenter = :userCenter ")
	public int buscarUserCenter(@Param("userCenter") String userCenter);
}
