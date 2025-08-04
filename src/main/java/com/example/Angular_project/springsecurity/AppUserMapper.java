package com.example.Angular_project.springsecurity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


 
public class AppUserMapper implements RowMapper<AppUser> {
 
	public static final String BASE_SQL = "select id,username ,password  from app_user where status ='1'";
	
    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Integer userId = rs.getInt("id");
        String userName = rs.getString("username");
        String encrytedPassword = rs.getString("password");

        return new AppUser(userId,userName,encrytedPassword);
    }
 
}
