package com.example.Angular_project.springsecurity;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class AppRoleDAO extends JdbcDaoSupport {

   @Autowired
   public AppRoleDAO(DataSource dataSource) {
       this.setDataSource(dataSource);
   }

   public List<String> getRoleNames(Integer userId) {
       String sql = "select c.role_name  from user_role a inner join app_user b on a.user_id = b.id inner join app_role c on a.role_id = c.id where b.id = ? ";

       Object[] params = new Object[] { userId };

       List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);

       return roles;
   }


    
}