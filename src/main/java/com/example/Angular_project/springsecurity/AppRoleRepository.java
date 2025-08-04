package com.example.Angular_project.springsecurity;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;





public interface AppRoleRepository extends JpaRepository<AppRole, Integer> {
	
	AppRole getById(Integer id);
	
	AppRoleEntity findById(int id);
	
	@Transactional
	@Modifying
	@Query(value="update app_role set is_delete =1 where id=:id",nativeQuery=true)
	void Isdelete(@Param("id") Integer id);
}
