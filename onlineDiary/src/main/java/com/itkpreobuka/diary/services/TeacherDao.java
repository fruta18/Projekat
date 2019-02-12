package com.itkpreobuka.diary.services;

import java.util.List;
import java.util.Optional;

import com.itkpreobuka.diary.entities.TeacherEntity;



public interface TeacherDao {
	
	//Optional<TeacherEntity> getById(Long id);
	TeacherEntity getById(Long id);
	List<TeacherEntity> getAll();
	TeacherEntity update(TeacherEntity newTeacher, Long id);
	TeacherEntity saveTeacher(TeacherEntity newTeacher);
	

}
