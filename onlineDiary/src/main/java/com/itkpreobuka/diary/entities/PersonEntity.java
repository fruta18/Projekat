

package com.itkpreobuka.diary.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Version;
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

public abstract class PersonEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	@GeneratedValue
	protected String code;
	@Version
	protected Integer version;
	
	protected String firstName;
	protected String lastName;
	protected Date dateOfBirth;
	protected String address;
	protected String jmbg;
	protected String email;
	protected String phoneNumber;
	protected String gender;
	
	@OneToMany(mappedBy = "persons", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<UserEntity> persons = new ArrayList<>();
	
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public PersonEntity() {
		super();
		
		
		
	}
	public PersonEntity(Long id, String code, Integer version, String firstName, String lastName, Date dateOfBirth,
			String address, String jmbg, String email, String phoneNumber, String gender) {
		super();
		this.id = id;
		this.code = code;
		this.version =1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.jmbg = jmbg;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		
	}
	/*public PersonEntity(int i, String string, String firstName2, String lastName2, String address2, String jmbg2,
			String email2, String phoneNumber2, ArrayList arrayList) {
		// TODO Auto-generated constructor stub
	}*/
	
	
	
	
	
}
