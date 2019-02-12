package com.itkpreobuka.diary.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itkpreobuka.diary.entities.DepartmentEntity;
import com.itkpreobuka.diary.entities.ParentEntity;
import com.itkpreobuka.diary.entities.UserEntity;
import com.itkpreobuka.diary.repositories.ParentRepository;

@Service
public class ParentService implements ParentDao{

	@Autowired
	private ParentRepository parentRepository;

	public ParentEntity getParentById(Long id) {

		return parentRepository.getById(id);
	}

	public List<ParentEntity> getAll() {

		return (List<ParentEntity>) parentRepository.findAll();
	}

	/*public ParentEntity save(ParentEntity parent) {

		return parentRepository.save(parent);
	}*/

	public ParentEntity delete(Long id) {
		ParentEntity parent = parentRepository.findById(id).get();
		if(parent == null) {
			return null;
		}else
			
		parentRepository.delete(parent);
		return parent;
	}
	

	
	public ParentEntity save(ParentEntity newParent) {
		
		ParentEntity parent = new ParentEntity();
		if(newParent==null) {
			return null;
		}else {
			parent.setCode(newParent.getCode());
			parent.setFirstName(newParent.getFirstName());
			parent.setLastName(newParent.getLastName());
			parent.setEmail(newParent.getEmail());
			parent.setJmbg(newParent.getJmbg());
			parent.setPhoneNumber(newParent.getPhoneNumber());
			parent.setAddress(newParent.getAddress());
			parent.setDateOfBirth(newParent.getDateOfBirth());
			parent.setProfessionalQualifications(newParent.getProfessionalQualifications());
			parent.setGender(newParent.getGender());
			//parent.setStudent treba odrediti
			return parentRepository.save(newParent);
		}
	}
	
	public ParentEntity update(ParentEntity updateParent, Long id) {
		ParentEntity parent = parentRepository.findById(id).get();
		
		if(parent == null) {
			return null;
		}else if(updateParent == null) {
			return null;
		}else {
			parent.setCode(updateParent.getCode());
			parent.setFirstName(updateParent.getFirstName());
			parent.setLastName(updateParent.getLastName());
			parent.setEmail(updateParent.getEmail());
			parent.setJmbg(updateParent.getJmbg());
			parent.setPhoneNumber(updateParent.getPhoneNumber());
			parent.setAddress(updateParent.getAddress());
			parent.setDateOfBirth(updateParent.getDateOfBirth());
			parent.setProfessionalQualifications(updateParent.getProfessionalQualifications());
			parent.setGender(updateParent.getGender());
			
			return parentRepository.save(parent);
		}
		}

	


	public boolean removeParent(Long id) {
		ParentEntity p = parentRepository.getById(id);
		if (p!=null) {
			parentRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public Optional<ParentEntity> findParentByFirstName(String firstName) {
		return parentRepository.findParentByFirstName(firstName);
	}
	public Optional<ParentEntity> findParentByLastName(String lastName) {
		return parentRepository.findParentByLastName(lastName);
	}
	
	public Optional<ParentEntity> findParentByAddress(String address) {
		return parentRepository.findParentByAddress(address);
	}
	}



