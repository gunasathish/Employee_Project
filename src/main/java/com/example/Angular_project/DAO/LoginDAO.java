package com.example.Angular_project.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginDAO {
	
	@JsonProperty("username")
	private String userName;
	
	@JsonProperty("password")
	private String password;

}
