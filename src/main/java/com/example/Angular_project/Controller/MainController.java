package com.example.Angular_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Angular_project.DAO.LoginDAO;
import com.example.Angular_project.springsecurity.AppUser;
import com.example.Angular_project.springsecurity.AppUserRepository;
import com.example.Angular_project.springsecurity.UserDetailsServiceImpl;

@RestController
//@RequestMapping("/web/api")
@CrossOrigin
public class MainController {
	
	   
	  @Autowired
	  AppUserRepository appUserRepo;
	  
	  @Autowired
		UserDetailsServiceImpl userDetailsService;
	   
	  @PostMapping("/login")
	  public ResponseEntity<?> logindataStored(@RequestBody LoginDAO loginobject) {
	      AppUser loginUser = appUserRepo.getByUserName(loginobject.getUserName());

	      if (loginUser != null) {
	          try {
	              UserDetails userDetails = userDetailsService.loadUserByUsername(loginobject.getUserName());
	       
	              return ResponseEntity.ok(userDetails); // Return 200 with user details
	          } catch (Exception e) {
	              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                                   .body("Error loading user details: " + e.getMessage());
	          }
	      }

	      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                           .body("Invalid username or password");
	  }

	   
	   
	   
	
}
