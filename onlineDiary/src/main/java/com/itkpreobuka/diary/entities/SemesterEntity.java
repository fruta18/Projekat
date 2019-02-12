package com.itkpreobuka.diary.entities;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itkpreobuka.diary.entities.dto.SemesterDto;


@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SemesterEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	private String code;
	@Version
	private Integer version;
	private Date startDate;
	private Date endDate;
	private Integer orderNumber;//na nivou validacije da je min 1 i max 2
	
	@JsonIgnore
	@OneToMany(mappedBy = "semesterMark", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<MarkEntity> semesterMark;// da li treba get i set metoda ili samo gde je @ManyToOne?
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "semester", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<SchoolYearEntity> semester;// da li treba ovako
	
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
	public List<MarkEntity> getSemesterMark() {
		return semesterMark;
	}
	public void setSemesterMark(List<MarkEntity> semesterMark) {
		this.semesterMark = semesterMark;
	}
	public List<SchoolYearEntity> getSemester() {
		return semester;
	}
	public void setSemester(List<SchoolYearEntity> semester) {
		this.semester = semester;
	}
	public SemesterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SemesterEntity(Long id, String code, Integer version, Date startDate, Date endDate, Integer orderNumber,
			List<MarkEntity> semesterMark, List<SchoolYearEntity> semester) {
		super();
		this.id = id;
		this.code = code;
		this.version = version;
		this.startDate = startDate;
		this.endDate = endDate;
		this.orderNumber = orderNumber;
		this.semesterMark = semesterMark;
		this.semester = semester;
	}
	
	public SemesterEntity(SemesterDto semester) {
		this.id=semester.getId();
		this.startDate=semester.getStartDate();
		this.endDate=semester.getEndDate();
		this.orderNumber=semester.getOrderNumber();
	}
	

	
}
