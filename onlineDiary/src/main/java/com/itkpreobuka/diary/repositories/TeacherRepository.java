package com.itkpreobuka.diary.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.itkpreobuka.diary.entities.TeacherEntity;

public interface TeacherRepository extends CrudRepository<TeacherEntity, Long> {

	//Optional <TeacherEntity> getById(Long id);
    TeacherEntity getById(Long id);
}
