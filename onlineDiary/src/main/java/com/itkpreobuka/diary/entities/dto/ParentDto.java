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

public class ParentDto {

	

	
	@JsonView(Views.Public.class)
	private Long id;
	
	@JsonView(Views.Private.class)
	@NotNull(message="First name must be provided.")
	@Size(min=2,max=30,message="First name must be between {min} and {max} characters long.")
	private String firstName;
	
	@JsonView(Views.Private.class)
	@NotNull(message="LastName  must be provided.")
	@Size(min=2,max=30,message="Last name must be between {min} and {max} characters long.")
	private String lastName;
	
	@JsonView(Views.Private.class)
	@NotNull(message = "Email must be provided.")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
	message="Email is not valid.")
	private String email;
	
	@JsonView(Views.Admin.class)
	@NotNull(message = "PhoneNumber must be provided.")
	@Size(min=9,max=30,message="PhoneNumber must be between {min} and {max} characters long.")
	private String phoneNumber;
	
	@JsonView(Views.Private.class)
	@NotNull(message="Address must be provided.")
	@Size(min=2,max=30,message="Address must be between {min} and {max} characters long.")
	private String address;
	
	@JsonView(Views.Admin.class)
	@NotNull(message="jmbg name must be provided.")
	@Max(value= 13,message="jmbg must be 13 characters long.")// da li ide max ?
	private String jmbg;
	
	@JsonView(Views.Admin.class)
	@NotNull(message="jmbg name must be provided.")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyy-MM-dd",timezone="Europe/Belgrade")
	private Date dateOfBirth;
	
	@JsonView(Views.Private.class)
	@NotNull(message="ProffesionalQualification name must be provided.")
	@Size(min=5,max=30,message="Address must be between {min} and {max} characters long.")
	private String professionalQualifications;
	
	@JsonView(Views.Private.class)
	@NotNull(message="Gender must be provided.")
	private String gender;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	
	
	/*public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}*/
	public String getProfessionalQualifications() {
		return professionalQualifications;
	}
	public void setProfessionalQualifications(String professionalQualifications) {
		this.professionalQualifications = professionalQualifications;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public ParentDto(Long id,String firstName,String email,String phoneNumber,String address, String jmbg, String professionalQualifications,String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.jmbg = jmbg;
		this.professionalQualifications = professionalQualifications;
		this.gender = gender;
	}
	public ParentDto() {
		super();
		// TODO Auto-generated constructor stub
	}	
		
		
			public ParentDto(ParentEntity parentEntity){
			this.id=parentEntity.getId();
			this.firstName = parentEntity.getFirstName();
			this.lastName = parentEntity.getLastName();
			this.address = parentEntity.getAddress();
			this.email=parentEntity.getEmail();
			
			
		}
	
	/*public ParentDto(StudentEntity parents) {
		this.id=parents.getId();
		this.firstName = parents.getFirstName();
		this.lastName = parents.getLastName();
	}*/
			
}
