package com.itkpreobuka.diary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.itkpreobuka.diary.entities.SchoolYearEntity;


public interface SchoolYearRepository extends CrudRepository<SchoolYearEntity, Long> {
	
	SchoolYearEntity getById(Long id);
	
	
}
