/**
 * 
 */
package com.example.Angular_project.springsecurity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author D N MalliKarjun
 *
 */
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	AppUser getById(Integer id);
	
	AppUser getByUserName(String userName);
}
