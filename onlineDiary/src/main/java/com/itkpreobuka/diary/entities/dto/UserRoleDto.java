package com.itkpreobuka.diary.entities.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import com.itkpreobuka.diary.entities.UserRole;
import com.itkpreobuka.diary.security.Views;

public class UserRoleDto {


	
	@JsonView(Views.Public.class)
	private Long id;
	

	@JsonView(Views.Private.class)
	@NotNull(message = "RoleCode must be provided.")
	private String roleCode;
	

	@JsonView(Views.Private.class)
	@NotNull(message = "RoleName  must be provided.")
	@Size(min=5,max=7,message="RoleName must be between {min} and {max} characters long.")
	private String roleName;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRoleCode() {
		return roleCode;
	}


	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public UserRoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserRoleDto(Long id, String roleCode,String roleName) {
		super();
		this.id = id;
		this.roleCode = roleCode;
		this.roleName = roleName;
	}
	
	public UserRoleDto(UserRole rola) {
		this.id=rola.getId();
		this.roleName=rola.getRoleName();
		this.roleCode=rola.getRoleCode();
	}
	
}
