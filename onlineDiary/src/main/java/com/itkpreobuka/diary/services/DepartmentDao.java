package com.itkpreobuka.diary.services;

import java.util.List;

import com.itkpreobuka.diary.entities.DepartmentEntity;
import com.itkpreobuka.diary.entities.SchoolYearEntity;

public interface DepartmentDao {

	DepartmentEntity getById(Long id);

	List<DepartmentEntity> getAll();

	//List<DepartmentEntity> findDepartmentByTeacherId(Long teacherId);
}
