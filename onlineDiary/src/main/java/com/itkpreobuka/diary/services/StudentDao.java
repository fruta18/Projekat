package com.itkpreobuka.diary.services;

import java.util.List;
import java.util.Optional;

import com.itkpreobuka.diary.entities.StudentEntity;



public interface StudentDao {

	StudentEntity getById(Long id);
	List<StudentEntity> getAll();
	StudentEntity update(StudentEntity updateStudent, Long id);
	StudentEntity saveStudent(StudentEntity newStudent);
	//StudentEntity delete(Long id);
	
}
