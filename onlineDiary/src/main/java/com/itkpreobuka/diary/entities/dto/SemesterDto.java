package com.itkpreobuka.diary.entities.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.itkpreobuka.diary.entities.SemesterEntity;
import com.itkpreobuka.diary.security.Views;

public class SemesterDto {
	

	
	@JsonView(Views.Public.class)
	private Long id;
	
	
	@JsonView(Views.Public.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyy-MM-dd",timezone="Europe/Belgrade")
	private Date startDate;
	
	@JsonView(Views.Public.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyy-MM-dd",timezone="Europe/Belgrade")
	private Date endDate;
	
	@JsonView(Views.Public.class)
	@NotNull(message="OrderNumber must be provided.")
	@Max(value=2, message= "OrderNumber must be 1 or 2")
	private Integer orderNumber;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public SemesterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SemesterDto(Date startDate, Date endDate, Integer orderNumber) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.orderNumber = orderNumber;
	}
	public SemesterDto(SemesterEntity semester) {
		this.id=semester.getId();
		this.startDate=semester.getStartDate();
		this.endDate=semester.getEndDate();
		this.orderNumber=semester.getOrderNumber();
	}
	
	
}
