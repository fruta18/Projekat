package com.itkpreobuka.diary.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itkpreobuka.diary.entities.dto.UserDto;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String code;
	@Version
	private Integer version;
	
	private String username;
	private String password;
	private String repeatedPassword;
	
	
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name="persons")
	private PersonEntity persons;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name="roles")
	private UserRole roles;
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}

	public UserRole getRoles() {
		return roles;
	}


	public void setRoles(UserRole roles) {
		this.roles = roles;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getRepeatedPassword() {
		return repeatedPassword;
	}


	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}


	public PersonEntity getPersons() {
		return persons;
	}


	public void setPersons(PersonEntity persons) {
		this.persons = persons;
	}


	/**
	 * 
	 */
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public UserEntity(Long id, String code, Integer version, String username, String password, String repeatedPassword,
			PersonEntity persons, UserRole roles) {
		super();
		this.id = id;
		this.code = code;
		this.version = version;
		this.username = username;
		this.password = password;
		this.repeatedPassword = repeatedPassword;
		this.persons = persons;
		this.roles = roles;
	}


	public UserEntity(UserDto user) {
		this.id=user.getId();
		this.username=user.getUsername();
		this.password=user.getPassword();
		this.repeatedPassword =user.getRepeatedPassword();
		this.roles=user.getRoles();
		
	}


	
}

