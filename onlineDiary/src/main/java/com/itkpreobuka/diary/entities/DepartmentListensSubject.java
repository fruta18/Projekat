

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
public class DepartmentListensSubject {
	
	@Id
	private Long id;
	/*private MarkEntity mark;
	private TeacherTeachesSubject teacherSubject;*/
	
	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="markDepartment")
	private DepartmentEntity markDepartment;
	
/*	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="department")
	private DepartmentEntity department;*/
	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="teacherSubject")
	private TeacherTeachesSubject teacherSubject;
	
	@JsonIgnore
	@OneToMany(mappedBy = "listens", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<MarkEntity> listens = new ArrayList<>();

	
	
	public DepartmentListensSubject() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public DepartmentEntity getMarkDepartment() {
		return markDepartment;
	}



	public void setMarkDepartment(DepartmentEntity markDepartment) {
		this.markDepartment = markDepartment;
	}



	public TeacherTeachesSubject getTeacherSubject() {
		return teacherSubject;
	}



	public void setTeacherSubject(TeacherTeachesSubject teacherSubject) {
		this.teacherSubject = teacherSubject;
	}



	public List<MarkEntity> getListens() {
		return listens;
	}



	public void setListens(List<MarkEntity> listens) {
		this.listens = listens;
	}
	
	
}
