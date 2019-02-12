package com.itkpreobuka.diary.entities.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import com.itkpreobuka.diary.entities.SchoolYearEntity;
import com.itkpreobuka.diary.entities.SemesterEntity;
import com.itkpreobuka.diary.security.Views;

public class SchoolYearDto {


	
	@JsonView(Views.Public.class)
	private Long id;
	
	@JsonView(Views.Public.class)
	@NotNull(message="SchoolYear must be provided.")
	@Pattern(regexp="^(20[0-9][0-9])/(20[0-9][0-9])$")
	private String year;

	@JsonView(Views.Public.class)
	@NotNull(message="OrderNumber must be provided.")
	@Max(value=2, message= "OrderNumber must be 1 or 2")
	private SemesterEntity semester;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SchoolYearDto() {
		super();
		
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public SchoolYearDto(String year) {
		super();
		this.year = year;
	}

	public SemesterEntity getSemester() {
		return semester;
	}

	public void setSemester(SemesterEntity semester) {
		this.semester = semester;
	}

	public SchoolYearDto(Long id, String year) {
		super();
		this.id = id;
		this.year = year;
	}
	
		public SchoolYearDto(SchoolYearEntity schoolYear) {
		this.id=schoolYear.getId();
		this.year=schoolYear.getYear();
		this.semester=schoolYear.getSemester();
		
		}
	
}
