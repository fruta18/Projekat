package com.itkpreobuka.diary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.itkpreobuka.diary.entities.SemesterEntity;
import com.itkpreobuka.diary.entities.TeacherEntity;

public interface SemesterRepository extends CrudRepository<SemesterEntity, Long> {
	SemesterEntity getById(Long id);
}
