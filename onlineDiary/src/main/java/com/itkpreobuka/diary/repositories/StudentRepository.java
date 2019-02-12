package com.itkpreobuka.diary.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.itkpreobuka.diary.entities.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

	StudentEntity getById(Long id);
	StudentEntity getByJmbg(String jmbg);

}
