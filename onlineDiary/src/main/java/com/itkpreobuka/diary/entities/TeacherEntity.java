
package com.itkpreobuka.diary.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itkpreobuka.diary.entities.dto.TeacherDto;

@Entity
public class TeacherEntity extends PersonEntity{

	@JsonIgnore
	@OneToMany(mappedBy = "teacherE", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<TeacherTeachesSubject> teacherE = new ArrayList<>();
	
	
	
	private String occupation;

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
	
	public List<TeacherTeachesSubject> getTeacherE() {
		return teacherE;
	}

	public void setTeacherE(List<TeacherTeachesSubject> teacherE) {
		this.teacherE = teacherE;
	}

	public TeacherEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeacherEntity(Long id, String code, Integer version, String firstName, String lastName, Date dateOfBirth,
			String address, String jmbg, String email, String phoneNumber, String gender,
			String occupation, List<TeacherTeachesSubject> teacherE) {
		super(id, code, version, firstName, lastName, dateOfBirth, address, jmbg, email, phoneNumber, gender);
		this.occupation = occupation;
		this.teacherE = teacherE;
	}
	
	public TeacherEntity(TeacherDto teacher) {
		this.id=teacher.getId();
		this.firstName=teacher.getFirstName();
		this.lastName=teacher.getLastName();
		this.address=teacher.getAddress();
		this.email=teacher.getEmail();
		this.phoneNumber=teacher.getPhoneNumber();
		this.jmbg=teacher.getJmbg();
		
	}
}
