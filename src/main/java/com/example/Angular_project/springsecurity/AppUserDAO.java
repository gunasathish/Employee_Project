package com.example.Angular_project.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AppUserDAO {
 
    @Autowired
    JdbcTemplate jdbcTemplate;
 
    public AppUser findUserAccount(String userName) {
  
        String sql = AppUserMapper.BASE_SQL + " and username = ? ";
 
        Object[] params = new Object[] { userName };
        AppUserMapper mapper = new AppUserMapper();
        try {
            AppUser userInfo = jdbcTemplate.queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }




}
