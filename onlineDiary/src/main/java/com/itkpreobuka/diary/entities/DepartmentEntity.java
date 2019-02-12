package com.itkpreobuka.diary.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itkpreobuka.diary.entities.dto.DepartmentDto;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DepartmentEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String code;
	@Version
	private Integer version;
	private Integer classNumber;// RAZRED(1-9)
	private Integer departmentNumber;// ODELJENJE(1-5)
	
	@JsonIgnore
	@OneToMany(mappedBy = "markDepartment", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<DepartmentListensSubject> markDepartment = new ArrayList<>();
	
	@OneToMany(mappedBy = "studentDepartment", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<StudentBelongsToDepartment> studentDepartment= new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="departmentForYear")
	private SchoolYearEntity departmentForYear;
	
	
	

	
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

	public Integer getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}

	public Integer getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(Integer departmentNumber){
		this.departmentNumber= departmentNumber;
	}

	
	public List<DepartmentListensSubject> getMarkDepartment() {
		return markDepartment;
	}

	public void setMarkDepartment(List<DepartmentListensSubject> markDepartment) {
		this.markDepartment = markDepartment;
	}

	public List<StudentBelongsToDepartment> getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(List<StudentBelongsToDepartment> studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	public SchoolYearEntity getDepartmentForYear() {
		return departmentForYear;
	}

	public void setDepartmentForYear(SchoolYearEntity departmentForYear) {
		this.departmentForYear = departmentForYear;
	}

	public DepartmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentEntity(Long id, String code, Integer version, Integer classNumber, Integer departmentNumber,
			List<DepartmentListensSubject> markDepartment, List<StudentBelongsToDepartment> studentDepartment,
			SchoolYearEntity departmentForYear) {
		super();
		this.id = id;
		this.code = code;
		this.version = version;
		this.classNumber = classNumber;
		this.departmentNumber = departmentNumber;
		this.markDepartment = markDepartment;
		this.studentDepartment = studentDepartment;
		this.departmentForYear = departmentForYear;
	}

	public DepartmentEntity(DepartmentDto department) {
		this.id=department.getId();
		this.classNumber =department.getClassNumber();
		this.departmentNumber = department.getDepartmentNumber();
		this.departmentForYear = department.getDepartmentForYear();
		this.version=1;
	}
	}
	
	
	

	

