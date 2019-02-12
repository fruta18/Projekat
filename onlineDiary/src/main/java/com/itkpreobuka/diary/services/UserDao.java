package com.itkpreobuka.diary.services;

import java.util.List;
import java.util.Optional;

import com.itkpreobuka.diary.entities.UserEntity;



public interface UserDao {
	UserEntity getById(Long id);

	
}
