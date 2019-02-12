package com.itkpreobuka.diary.entities.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.itkpreobuka.diary.entities.ParentEntity;
import com.itkpreobuka.diary.entities.StudentEntity;
import com.itkpreobuka.diary.security.Views;

public class StudentDto {


	@JsonView(Views.Public.class)
	private Long id;
	
	
	@JsonView(Views.Private.class)
	@NotNull(message="First name must be provided.")
	@Size(min=2,max=30,message="First name must be between {min} and {max} characters long.")
	private String firstName;
	
	@JsonView(Views.Private.class)
	@NotNull(message="Last name must be provided.")
	@Size(min=2,max=30,message="Last name must be between {min} and {max} characters long.")
	private String lastName;
	
	@JsonView(Views.Private.class)
	@NotNull(message="Address must be provided.")
	@Size(min=2,max=30,message="Address must be between {min} and {max} characters long.")
	private String address;
	
	@JsonView(Views.Private.class)
	@NotNull(message = "Email must be provided.")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
	message="Email is not valid.")
	private String email;

	@JsonView(Views.Private.class)
	@NotNull(message = "Parents must be provided.")
	private ParentEntity parents;


	@JsonView(Views.Admin.class)
	@NotNull(message="jmbg must be provided.")
	@Pattern(regexp = "^[0-9]{13}$", message = "JMBG must have 13 characters!")
	private String jmbg;
	

	@JsonView (Views.Private.class)
	@NotNull(message="You have to add a parent!")
	private Long parentID;
	
	
	
	@JsonView(Views.Private.class)
	@NotNull(message = "PhoneNumber must be provided.")
	@Size(min=9,max=30,message="PhoneNumber must be between {min} and {max} characters long.")
	private String phoneNumber;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ParentEntity getParents() {
		return parents;
	}
	public void setParents(ParentEntity parents) {
		this.parents = parents;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public StudentDto(Long id, String firstName, String lastName, String address,String email,ParentEntity parents, String jmbg, String phoneNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.jmbg = jmbg;
		this.parents = parents;
		this.phoneNumber=phoneNumber;
		
	}
	public StudentDto(StudentEntity student) {
		this.id=student.getId();
		this.firstName=student.getFirstName();
		this.lastName=student.getLastName();
		this.address=student.getAddress();
		this.email=student.getEmail();
		this.jmbg=student.getJmbg();
		this.parents=student.getParents();	

		
		
	
		
	}

	
	
	
	
}
