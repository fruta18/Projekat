package com.itkpreobuka.diary.entities.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import com.itkpreobuka.diary.entities.SubjectEntity;
import com.itkpreobuka.diary.security.Views;

public class SubjectDto {
	

	
	@JsonView(Views.Public.class)
	private Long id;
	
	@JsonView(Views.Private.class)
	@NotNull(message="Subject name must be provided.")
	@Size(min=4,max=30,message="Subject name must be between {min} and {max} characters long.")
	private String name;
	
	
	
	@JsonView(Views.Private.class)
	@NotNull(message="Subject fond must be provided")
	@Size(min=1,max=5, message=" Subject fond must be beetween {min} and {max} characters long")
	private Integer fond;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String Name) {
		this.name = name;
	}



	public Integer getFond() {
		return fond;
	}



	public void setFond(Integer fond) {
		this.fond = fond;
	}



	public SubjectDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public SubjectDto(Long id,
			@NotNull(message = "Subject name must be provided.") @Size(min = 4, max = 30, message = "Subject name must be between {min} and {max} characters long.") String subjectName,
			@NotNull(message = "Subject fond must be provided") @Size(min = 1, max = 5, message = " Subject fond must be beetween {min} and {max} characters long") Integer fond) {
		super();
		this.id = id;
		this.name = name;
		this.fond = fond;
	}

	public SubjectDto(SubjectEntity subject) {
		this.id=subject.getId();
		this.name=subject.getName();
		this.fond=subject.getFond();
	}
	
}
