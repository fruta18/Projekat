package com.itkpreobuka.diary.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itkpreobuka.diary.controllers.util.RestError;
import com.itkpreobuka.diary.entities.DepartmentEntity;
import com.itkpreobuka.diary.entities.MarkEntity;
import com.itkpreobuka.diary.entities.SemesterEntity;
import com.itkpreobuka.diary.entities.UserEntity;
import com.itkpreobuka.diary.entities.UserRole;
import com.itkpreobuka.diary.entities.dto.DepartmentDto;
import com.itkpreobuka.diary.entities.dto.MarkDto;
import com.itkpreobuka.diary.entities.dto.SemesterDto;
import com.itkpreobuka.diary.entities.dto.UserDto;
import com.itkpreobuka.diary.entities.dto.UserRoleDto;
import com.itkpreobuka.diary.services.UserRoleService;

@RestController
@RequestMapping(path = "/api/v1/userRole")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	ResponseEntity<?> getUserRoleById(@PathVariable Long id) {
		try {

			Optional<UserRole> role = userRoleService.getById(id);

			if (role != null) {
				return new ResponseEntity<UserRoleDto>(new UserRoleDto(role.get()), HttpStatus.OK);
			}
			return new ResponseEntity<RestError>(new RestError(1, "User not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/roleName/{roleName}")
	ResponseEntity<?> findUserByRoleName(@PathVariable String roleName){
		try {
			Optional <UserRole> roles= userRoleService.findUserByRoleName(roleName);
			
			if(roles!=null) {
				return new ResponseEntity<UserRoleDto>(new UserRoleDto(roles.get()),HttpStatus.OK);
			
			
			}
			return new ResponseEntity<RestError>(new RestError(1, "RoleName not found"), HttpStatus.NOT_FOUND);
			
		}catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserRoleDto>> getAll() {

		List<UserRole> userRoles = userRoleService.getAll();
		List<UserRoleDto> userRoledto = new ArrayList<>();
		for (UserRole d : userRoles) {
			userRoledto.add(new UserRoleDto(d));
		}
		return new ResponseEntity<>(userRoledto, HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.PUT , value = "/{id}") 
	public ResponseEntity<?> updateUserRole(@PathVariable Long id,  @RequestBody UserRoleDto updateUserRole) { 
		
		try {
			UserRole userRole = new UserRole(updateUserRole);
			UserRoleDto newUserRole = new UserRoleDto (userRoleService.update(userRole, id));
			if(userRole != null) {
				
			return new ResponseEntity<>(newUserRole, HttpStatus.OK);
				
			}
			return new ResponseEntity<RestError>(new RestError(1,"UserRole not found"), HttpStatus.NOT_FOUND);
		}catch (Exception e) { 
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		}
	
	
		@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> writeUserRole(@RequestBody UserRoleDto userRoleDto) {
		try {
			 UserRole ur = new UserRole(userRoleDto);
			UserRoleDto newUserRole = new UserRoleDto(userRoleService.saveUserRole(ur));
			if (ur != null) {
				return new ResponseEntity<>(newUserRole, HttpStatus.OK);
			}
			return new ResponseEntity<RestError>(new RestError(1, "Creating failed"), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
			@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteUserRole(@PathVariable Long id) {
		try {
			if(userRoleService.removeUserRole(id)) {
				
				return new ResponseEntity<RestError>(new RestError(1, "Delete successfully!"), HttpStatus.OK);}
			else {
				return new ResponseEntity<RestError>(new RestError(2, "UserRole not found!"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(3, "Can't delete that department"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}