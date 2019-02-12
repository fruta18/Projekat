package com.itkpreobuka.diary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.itkpreobuka.diary.entities.MarkEntity;
import com.itkpreobuka.diary.entities.StudentEntity;

public interface MarkRepository extends CrudRepository<MarkEntity, Long> {

	MarkEntity getById(Long id);
}
