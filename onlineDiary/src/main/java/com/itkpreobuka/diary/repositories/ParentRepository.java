package com.itkpreobuka.diary.repositories;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.itkpreobuka.diary.entities.ParentEntity;
import com.itkpreobuka.diary.entities.UserEntity;

public interface ParentRepository extends CrudRepository<ParentEntity, Long> {

	ParentEntity getById(Long id);


	Optional<ParentEntity> findParentByAddress(String address);
	Optional<ParentEntity> findParentByFirstName(String firstName);
	Optional<ParentEntity> findParentByLastName(String lastName);

	
	

}
