package com.itkpreobuka.diary.entities;

import java.util.ArrayList;
import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itkpreobuka.diary.entities.dto.MarkDto;
import com.itkpreobuka.diary.enumerations.NumberGrade;
import com.itkpreobuka.diary.enumerations.TypeOfMark;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MarkEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	private String code;
	@Version
	private Integer version;
	private Integer mark;
	private TypeOfMark type;
	private Date dateOfExamination;
	
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name="semesterMark")
	private SemesterEntity semesterMark;  
	
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name="belongs")
	private StudentBelongsToDepartment belongs;  
	
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name="listens")
	private DepartmentListensSubject listens;  
	
	
	//id od slusa i pripada 
	
	
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
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	public TypeOfMark getType() {
		return type;
	}
	public void setType(TypeOfMark type) {
		this.type = type;
	}
	
	
	public Date getDateOfExamination() {
		return dateOfExamination;
	}
	public void setDateOfExamination(Date dateOfExamination) {
		this.dateOfExamination = dateOfExamination;
	}
	public SemesterEntity getSemesterMark() {
		return semesterMark;
	}
	public void setSemesterMark(SemesterEntity semesterMark) {
		this.semesterMark = semesterMark;
	}
	public StudentBelongsToDepartment getBelongs() {
		return belongs;
	}
	public void setBelongs(StudentBelongsToDepartment belongs) {
		this.belongs = belongs;
	}
	public DepartmentListensSubject getListens() {
		return listens;
	}
	public void setListens(DepartmentListensSubject listens) {
		this.listens = listens;
	}
	/**
	 * 
	 */
	public MarkEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MarkEntity(Long id, String code, Integer version, Integer mark, TypeOfMark type, Date dateOfExamination,
			SemesterEntity semesterMark, StudentBelongsToDepartment belongs, DepartmentListensSubject listens) {
		super();
		this.id = id;
		this.code = code;
		this.version = version;
		this.mark = mark;
		this.type = type;
		this.dateOfExamination = dateOfExamination;
		this.semesterMark = semesterMark;
		this.belongs = belongs;
		this.listens = listens;
	}
	
public MarkEntity(MarkDto mark) {
		
		this.id=mark.getId();
		this.mark=mark.getMark();
		this.type=mark.getType();
		this.dateOfExamination=mark.getDateOfExamination();
		this.semesterMark=mark.getSemesterMark();
		this.belongs=mark.getBelongs();
	//	this.listens=mark.getListens();
		
		
	}
	
	
}
