package com.itkpreobuka.diary.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StudentBelongsToDepartment {
	
	@Id
	private Long id;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="student")
	private StudentEntity student;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="studentDepartment")
	private DepartmentEntity studentDepartment;
	
	@JsonIgnore
	@OneToMany(mappedBy = "belongs", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<MarkEntity> belongs = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public DepartmentEntity getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(DepartmentEntity studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	public List<MarkEntity> getBelongs() {
		return belongs;
	}

	public void setBelongs(List<MarkEntity> belongs) {
		this.belongs = belongs;
	}

	
	
}
