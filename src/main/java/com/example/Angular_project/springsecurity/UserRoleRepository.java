package com.example.Angular_project.springsecurity;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	UserRole getByUserId(Integer userId);

	List<UserRole> findAllByRoleIdIn(List<Integer> userId);

	@Transactional
	@Modifying
	@Query(value = "update user_role set is_delete =1 where id=:id", nativeQuery = true)
	void Isdelete(@Param("id") Integer id);

}
