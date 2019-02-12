
package com.itkpreobuka.diary.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itkpreobuka.diary.entities.dto.UserRoleDto;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Version
	private Integer version;
	private String roleCode;
	private String roleName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<UserEntity> roles = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
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
	/**
	 * 
	 */
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRole(Long id, Integer version, String roleCode, String roleName, List<UserEntity> roles) {
		super();
		this.id = id;
		this.version = version;
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.roles = roles;
	}
	
	public UserRole(UserRoleDto rola) {
		this.id=rola.getId();
		this.roleName=rola.getRoleName();
		this.roleCode=rola.getRoleCode();
	}
}
