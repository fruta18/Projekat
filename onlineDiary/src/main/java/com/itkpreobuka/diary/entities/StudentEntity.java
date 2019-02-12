
package com.itkpreobuka.diary.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itkpreobuka.diary.entities.dto.ParentDto;
import com.itkpreobuka.diary.entities.dto.StudentDto;
 
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StudentEntity extends PersonEntity{
	
	
	
	//private List<MarkEntity> marks= new ArrayList<>();
	 
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<StudentBelongsToDepartment> student = new ArrayList<>();
	
	
	


	@ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name = "parents", nullable = false)
	private ParentEntity parents;
	

	public List<StudentBelongsToDepartment> getStudent() {
		return student;
	}

	public void setStudent(List<StudentBelongsToDepartment> student) {
		this.student = student;
	}

	public ParentEntity getParents() {
		return parents;
	}

	public void setParents(ParentEntity parents) {
		this.parents = parents;
	}

	public StudentEntity() {
		super();
		
	}

	public StudentEntity(Long id, String code, Integer version, String firstName, String lastName, Date dateOfBirth,
			String address, String jmbg, String email, String phoneNumber, String gender,
			List<StudentBelongsToDepartment> student, ParentEntity parents) {
		super(id, code, version, firstName, lastName, dateOfBirth, address, jmbg, email, phoneNumber, gender);
		this.student = student;
		this.parents = parents;
	}
	
	public StudentEntity(StudentDto student) {
		this.firstName=student.getFirstName();
		this.lastName=student.getLastName();
		this.address=student.getAddress();
		this.email=student.getEmail();
		this.jmbg=student.getJmbg();
	this.parents=student.getParents();		
	
	}
	
	
/*
		public void updateStudent(StudentEntity s) {
			setAddress(s.getAddress());
			setFirstName(s.getFirstName());
			setLastName(s.getLastName()); 
			setEmail(s.getEmail());
			setJmbg(s.getJmbg());
			setPhoneNumber(s.getPhoneNumber());
		
			
			
		}
*/

	
}
	
	

