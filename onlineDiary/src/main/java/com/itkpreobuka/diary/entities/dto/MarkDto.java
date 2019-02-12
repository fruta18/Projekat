package com.itkpreobuka.diary.entities.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.itkpreobuka.diary.entities.DepartmentListensSubject;
import com.itkpreobuka.diary.entities.MarkEntity;
import com.itkpreobuka.diary.entities.SemesterEntity;
import com.itkpreobuka.diary.entities.StudentBelongsToDepartment;
import com.itkpreobuka.diary.enumerations.TypeOfMark;
import com.itkpreobuka.diary.security.Views;

public class MarkDto {


	
	@JsonView(Views.Public.class)
	private Long id;
	
	@JsonView(Views.Private.class)
	@Range(min=1,max=5, message= "Mark must be between 1 and 5")
	private Integer mark;
	
	private SemesterEntity semesterMark;  
	
	@JsonView(Views.Private.class)
	@NotNull(message="Last name must be provided.")
	private TypeOfMark type;
	
	@JsonView(Views.Private.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyy-MM-dd",timezone="Europe/Belgrade")
	private Date dateOfExamination;

	private StudentBelongsToDepartment belongs; 
	
	private DepartmentListensSubject listens;  
	
	
	public DepartmentListensSubject getListens() {
		return listens;
	}

	public void setListens(DepartmentListensSubject listens) {
		this.listens = listens;
	}

	public StudentBelongsToDepartment getBelongs() {
		return belongs;
	}

	public void setBelongs(StudentBelongsToDepartment belongs) {
		this.belongs = belongs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public MarkDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public MarkDto(Long id, Integer mark,
			SemesterEntity semesterMark,  TypeOfMark type,
			Date dateOfExamination, StudentBelongsToDepartment belongs, DepartmentListensSubject listens 
	) {
		super();
		this.id = id;
		this.mark = mark;
		this.semesterMark = semesterMark;
		this.type = type;
		this.dateOfExamination = dateOfExamination;
		this.belongs = belongs;
		this.listens=listens;
	}

	public MarkDto(MarkEntity mark) {
		
		this.id=mark.getId();
		this.mark=mark.getMark();
		this.type=mark.getType();
		this.dateOfExamination=mark.getDateOfExamination();
		this.semesterMark=mark.getSemesterMark();
		this.belongs=mark.getBelongs();
	//	this.listens=mark.getListens();
		
	}
	
}

