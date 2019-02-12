package com.itkpreobuka.diary.entities.dto;

//import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.itkpreobuka.diary.entities.UserEntity;
import com.itkpreobuka.diary.entities.UserRole;
import com.itkpreobuka.diary.security.Views;
public class UserDto {
	

	
	@JsonView(Views.Public.class)
	private Long id;
	
	@JsonProperty("username")
	@JsonView(Views.Private.class)
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
	message="Username/email is not valid.")
	private String username;
	
	@JsonProperty("password")
	@JsonView(Views.Private.class)
	@NotNull(message="Password must be provided.")
	@Size(min=5,max=10,message="Password must be between {min} and {max} characters long.")
	private String password;
	
	@JsonProperty("repeatedPassword")
	@JsonView(Views.Private.class)
	@NotNull(message="Password must be provided.")
	@Size(min=5,max=10,message="Password must be between {min} and {max} characters long.")
	private String repeatedPassword;
	
	@JsonProperty("role")
	@JsonView(Views.Private.class)
	private UserRole roles;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRepeatedPassword() {
		return repeatedPassword;
	}
	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
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
	
	
	public UserRole getRoles() {
		return roles;
	}
	public void setRole(UserRole roles) {
		this.roles = roles;
	}
	/**
	 * 
	 */
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public UserDto(Long id,String username, String password,String repeatedPassword,UserRole roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.repeatedPassword = repeatedPassword;
		this.roles = roles;
	}
	public UserDto(UserEntity user) {
		this.id=user.getId();
		this.username=user.getUsername();
		this.password=user.getPassword();
		this.repeatedPassword = user.getRepeatedPassword();
		this.roles=user.getRoles();
		
	}
	
	
}
