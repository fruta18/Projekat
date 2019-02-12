package com.itkpreobuka.diary.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itkpreobuka.diary.entities.dto.ParentDto;
import com.itkpreobuka.diary.entities.dto.StudentDto;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ParentEntity extends PersonEntity {

	@Column
	private String professionalQualifications;

	@JsonIgnore
	@OneToMany(mappedBy = "parents", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<StudentEntity> parents = new ArrayList<>();

	public String getProfessionalQualifications() {
		return professionalQualifications;
	}

	public void setProfessionalQualifications(String professionalQualifications) {
		this.professionalQualifications = professionalQualifications;
	}

	
	
	public List<StudentEntity> getParents() {
		return parents;
	}

	public void setParents(List<StudentEntity> parents) {
		this.parents = parents;
	}

	public ParentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParentEntity(Long id, String code, Integer version, String firstName, String lastName, Date dateOfBirth,
			String address, String jmbg, String email, String phoneNumber, String gender,
			String professionalQualifications, List<StudentEntity> parents) {
		super(id, code, version, firstName, lastName, dateOfBirth, address, jmbg, email, phoneNumber, gender);
		this.professionalQualifications = professionalQualifications;
		this.parents = parents;
	}


		public ParentEntity(ParentDto parentEntity) {
		this.id= parentEntity.getId();
		this.firstName = parentEntity.getFirstName();
		this.lastName = parentEntity.getLastName();
		this.address = parentEntity.getAddress();
		this.email=parentEntity.getEmail();
		
	}
	
	/*public ParentEntity(ParentDto parent) {
		super(1, UUID.randomUUID().toString(), parent.getFirstName(), parent.getLastName(), parent.getAddress(), parent.getPhoneNumber(), parent.getJmbg(),
				parent.getEmail(), new ArrayList<>());
		this.parents = new ArrayList<>();
	}
	*/
	}


