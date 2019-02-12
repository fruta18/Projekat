package com.itkpreobuka.diary.entities.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonView;
import com.itkpreobuka.diary.entities.DepartmentEntity;
import com.itkpreobuka.diary.entities.SchoolYearEntity;
import com.itkpreobuka.diary.security.Views;

public class DepartmentDto {


	
	@JsonView(Views.Public.class)
	private Long id;
	
	@JsonView(Views.Private.class)
	@NotNull
	@Range(min=1,max=5, message= "ClassNumber must be between 1 and 9")
	private Integer classNumber;
	
	@JsonView(Views.Private.class)
	@NotNull
	@Range(min=1,max=9, message= "DepartmentNumber must be between 1 and 5")
	private Integer departmentNumber;
	
	@JsonView(Views.Public.class)
	@NotNull(message="SchoolYear must be provided.")
	@Pattern(regexp="^(20[0-9][0-9])/(20[0-9][0-9])$")
	private SchoolYearEntity departmentForYear;
	
	public DepartmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public void setDepartmentNumber(Integer departmentNumber) {
		this.departmentNumber = departmentNumber;
	}


	public SchoolYearEntity getDepartmentForYear() {
		return departmentForYear;
	}


	public void setDepartmentForYear(SchoolYearEntity departmentForYear) {
		this.departmentForYear = departmentForYear;
	}


	
	
	public DepartmentDto(Long id,Integer classNumber, Integer departmentNumber,SchoolYearEntity departmentForYear) {
		super();
		this.id = id;
		this.classNumber = classNumber;
		this.departmentNumber = departmentNumber;
		this.departmentForYear = departmentForYear;
	}


	public DepartmentDto(DepartmentEntity department) {
		this.id=department.getId();
		this.classNumber = department.getClassNumber();
		this.departmentNumber = department.getDepartmentNumber();
		this.departmentForYear =department.getDepartmentForYear();
	}
	
	
}
