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
import com.itkpreobuka.diary.entities.dto.SubjectDto;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SubjectEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String code;
	@Version
	private Integer version;
	private String name;
	private Integer fond;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "teachingSubject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<TeacherTeachesSubject> teachingSubject = new ArrayList<>();

	/*@JsonIgnore
	@OneToMany(mappedBy= "subject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<SchoolYearEntity> subject;*/
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="schoolYear")
	private SchoolYearEntity schoolYear;

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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFond() {
		return fond;
	}
	public void setFond(Integer fond) {
		this.fond = fond;
	}
	
	
	
	public List<TeacherTeachesSubject> getTeachingSubject() {
		return teachingSubject;
	}
	public void setTeachingSubject(List<TeacherTeachesSubject> teachingSubject) {
		this.teachingSubject = teachingSubject;
	}
	public SchoolYearEntity getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(SchoolYearEntity schoolYear) {
		this.schoolYear = schoolYear;
	}
	public SubjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubjectEntity(Long id, String code, Integer version, String name, Integer fond,
			List<TeacherTeachesSubject> teachingSubject, SchoolYearEntity schoolYear) {
		super();
		this.id = id;
		this.code = code;
		this.version = version;
		this.name = name;
		this.fond = fond;
		this.teachingSubject = teachingSubject;
		this.schoolYear = schoolYear;
	}
	
	public SubjectEntity(SubjectDto subject) {
		this.id=subject.getId();
		this.name=subject.getName();
		this.fond=subject.getFond();
	}
}
