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
public class TeacherTeachesSubject {
	
	@Id
	private Long id;

	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="teacherE")
	private TeacherEntity teacherE;
	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="teachingSubject")
	private SubjectEntity teachingSubject;
	
	@JsonIgnore
	@OneToMany(mappedBy = "teacherSubject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<DepartmentListensSubject> teacherSubject = new ArrayList<>();
	
	public TeacherTeachesSubject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TeacherEntity getTeacherE() {
		return teacherE;
	}

	public void setTeacherE(TeacherEntity teacherE) {
		this.teacherE = teacherE;
	}

	public SubjectEntity getTeachingSubject() {
		return teachingSubject;
	}

	public void setTeachingSubject(SubjectEntity teachingSubject) {
		this.teachingSubject = teachingSubject;
	}

	public List<DepartmentListensSubject> getTeacherSubject() {
		return teacherSubject;
	}

	public void setTeacherSubject(List<DepartmentListensSubject> teacherSubject) {
		this.teacherSubject = teacherSubject;
	}
	
}
