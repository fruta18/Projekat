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
import com.itkpreobuka.diary.entities.dto.SchoolYearDto;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SchoolYearEntity {
	
	@Id
	@GeneratedValue
	
	private Long id;
	private String code;
	@Version
	private Integer version;
	private String year;
	

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="semester")
	private SemesterEntity semester;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "departmentForYear", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<DepartmentEntity> departmentForYear = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "schoolYear", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<SubjectEntity> schoolYear = new ArrayList<>();
	
	
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
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
	public SchoolYearEntity(Long id, String code, Integer version, String year, SemesterEntity semester,
			SubjectEntity subject, List<DepartmentEntity> departmentForYear, List<SubjectEntity> schoolYear) {
		super();
		this.id = id;
		this.code = code;
		this.version = 1;
		this.year = year;
		this.semester = semester;
		//this.subject = subject;
		this.departmentForYear = departmentForYear;
		this.schoolYear = schoolYear;
	}
	public SemesterEntity getSemester() {
		return semester;
	}
	public void setSemester(SemesterEntity semester) {
		this.semester = semester;
	}
	public List<DepartmentEntity> getDepartmentForYear() {
		return departmentForYear;
	}
	public void setDepartmentForYear(List<DepartmentEntity> departmentForYear) {
		this.departmentForYear = departmentForYear;
	}
	public List<SubjectEntity> getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(List<SubjectEntity> schoolYear) {
		this.schoolYear = schoolYear;
	}
	public SchoolYearEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SchoolYearEntity(SchoolYearDto schoolYear) {
		this.id=schoolYear.getId();
		this.year=schoolYear.getYear();
		this.semester=schoolYear.getSemester();
		}
	
}
