package com.itkpreobuka.diary.services;

import java.util.List;

import com.itkpreobuka.diary.entities.SchoolYearEntity;

public interface SchoolYearDao {

	SchoolYearEntity getById(Long id);

	List<SchoolYearEntity> getAll();

}
