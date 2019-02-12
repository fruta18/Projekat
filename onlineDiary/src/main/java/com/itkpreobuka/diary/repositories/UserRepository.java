package com.itkpreobuka.diary.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.itkpreobuka.diary.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity getById(Long id);

	Optional<UserEntity> findUserByUsername(String email);

	
}
