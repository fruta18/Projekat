package com.itkpreobuka.diary.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itkpreobuka.diary.entities.MarkEntity;
import com.itkpreobuka.diary.entities.SemesterEntity;
import com.itkpreobuka.diary.entities.UserEntity;
import com.itkpreobuka.diary.entities.UserRole;
import com.itkpreobuka.diary.repositories.UserRoleRepository;

@Service
public class UserRoleService implements UserRoleDao{

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	public Optional<UserRole> getById(Long id) {
		return userRoleRepository.findById(id);
		
	}

	public List<UserRole> getAll() {

		return (List<UserRole>) userRoleRepository.findAll();
	}
	
	public Optional<UserRole> findUserByRoleName(String roleName) {
		return userRoleRepository.findUserByRoleName(roleName);
	}

	public boolean removeUserRole(Long id) {
		Optional<UserRole> user = userRoleRepository.findById(id);
		if (user.isPresent()) {
			userRoleRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	
	public UserRole update(UserRole newUserRole, Long id) {
	UserRole 	userRole = userRoleRepository.findById(id).get();
	
	if(userRole == null) {
		return null;
	}else if(newUserRole == null) {
		return null;
	}else {
		userRole.setRoleCode(newUserRole.getRoleCode());
		userRole.setRoleName(newUserRole.getRoleName());
	
		return userRoleRepository.save(userRole);
	}
	}	
	
	
	public UserRole saveUserRole(UserRole newUserRole) {
		UserRole userRole = new UserRole();
		
	if(newUserRole==null) {
		return null;
	}else {
		
	userRole.setRoleCode(newUserRole.getRoleCode());
	userRole.setRoleName(newUserRole.getRoleName());
		
		return userRoleRepository.save(newUserRole);
		
	}

	}
}
