package com.example.Angular_project.springsecurity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="user_role")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "is_delete != 1")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;

	@Column(name = "user_id")
	public Integer userId;
	
	@Column(name = "role_id")
	public Integer roleId;
	
	@CreationTimestamp
	@Column(name = "created_on")
	public Date createdOn;
	
	@Builder.Default
	@Column(name = "is_delete")
	public Boolean is_Delete = false;
}
