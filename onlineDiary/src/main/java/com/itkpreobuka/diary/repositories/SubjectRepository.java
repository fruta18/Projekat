package com.itkpreobuka.diary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.itkpreobuka.diary.entities.SubjectEntity;


public interface SubjectRepository extends CrudRepository<SubjectEntity, Long> {

	SubjectEntity getById(Long id);
}
