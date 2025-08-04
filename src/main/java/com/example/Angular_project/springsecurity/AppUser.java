package com.example.Angular_project.springsecurity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "app_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username")
	private String userName;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "password")
	private String encryptedPassword;

	@Column(name = "status")
	private boolean status;

	@CreationTimestamp
	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "created_by")
	private Integer createdby;

	@Column(name = "updated_by")
	private Integer updatedby;

	@UpdateTimestamp
	@Column(name = "updated_on")
	private Date updatedOn;

	@Column(name = "is_delete")
	private Integer isDelete;

	@Transient
	private String RoleName;

	public AppUser(Integer userId, String userName, String encryptedPassword) {
		this.id = userId;
		this.userName = userName;
		this.encryptedPassword = encryptedPassword;
	}

}