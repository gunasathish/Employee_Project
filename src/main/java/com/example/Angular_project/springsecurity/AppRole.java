package com.example.Angular_project.springsecurity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="app_role")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "is_delete != 1")
public class AppRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;

	@Column(name = "role_name")
	public String roleName;
	
	@Column(name = "role_description")
	public String roleDescription;
	
	@Builder.Default
	@Column(name = "is_delete")
	public Boolean is_Delete = false;
}
