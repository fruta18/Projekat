package com.itkpreobuka.diary.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.itkpreobuka.diary.entities.UserRole;


public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

	Optional<UserRole> getById(Long id);

	Optional<UserRole> findUserByRoleName(String roleName);

}
