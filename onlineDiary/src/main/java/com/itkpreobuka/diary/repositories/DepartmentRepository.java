package com.itkpreobuka.diary.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.itkpreobuka.diary.entities.DepartmentEntity;
import com.itkpreobuka.diary.entities.SchoolYearEntity;


public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Long> {

	DepartmentEntity getById(Long id);
	DepartmentEntity findByClassNumber(Integer classNumber);
	DepartmentEntity getByDepartmentForYear(SchoolYearEntity departmentForYear);
	ArrayList<DepartmentEntity> findAllByDepartmentForYear(SchoolYearEntity departmentForYear);
	
	
	
}
