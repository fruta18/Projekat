package com.itkpreobuka.diary.services;

import java.util.List;


import com.itkpreobuka.diary.entities.ParentEntity;

public interface ParentDao {

	ParentEntity getParentById(Long id);
	List<ParentEntity> getAll();
	ParentEntity update(ParentEntity newParent, Long id);
	ParentEntity save(ParentEntity newParent);
	ParentEntity delete(Long id);
	/*ParentEntity findByFirstName(String firstName);
	ParentEntity findByLastName(String LastName);
	ParentEntity findByAddress(String address);*/
	
	
}
