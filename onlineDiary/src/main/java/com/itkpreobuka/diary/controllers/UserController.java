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
import com.itkpreobuka.diary.entities.UserEntity;
import com.itkpreobuka.diary.entities.UserRole;
import com.itkpreobuka.diary.entities.dto.DepartmentDto;
import com.itkpreobuka.diary.entities.dto.UserDto;
import com.itkpreobuka.diary.entities.dto.UserRoleDto;
import com.itkpreobuka.diary.services.UserService;

@RestController
@RequestMapping(path="/api/v1/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	//GET BY ID
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	ResponseEntity<?> getUserById(@PathVariable Long id){
		try {
			
			UserEntity user = userService.getById(id);
			
			if(user!=null) {
				UserDto uderdto = new UserDto(user);
				return new ResponseEntity<UserDto>(uderdto, HttpStatus.OK);
			}
			return new ResponseEntity<RestError>(new RestError(1, "User not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	//GET ALL
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> getAll() {

		List<UserEntity> users = userService.getAll();
		List<UserDto> userdto = new ArrayList<>();
		for (UserEntity d : users) {
			userdto.add(new UserDto(d));
		}
		return new ResponseEntity<>(userdto, HttpStatus.OK);

	}
	 // GET BY USERNAME
	@RequestMapping(method = RequestMethod.GET, value = "/username/{email}")
	ResponseEntity<?> findUserByUsername(@PathVariable String email){
		try {
			Optional <UserEntity> users= userService.findUserByUsername(email);
			
			if(users!=null) {
				return new ResponseEntity<UserDto>(new UserDto(users.get()),HttpStatus.OK);
			
			
			}
			return new ResponseEntity<RestError>(new RestError(1, "User not found"), HttpStatus.NOT_FOUND);
			
		}catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
	}
	
	// DELETE

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		try {
			if(userService.removeUser(id)) {
				
				return new ResponseEntity<RestError>(new RestError(1, "Delete successfully!"), HttpStatus.OK);}
			else {
				return new ResponseEntity<RestError>(new RestError(2, "User not found!"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(3, "Can't delete that user"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(method = RequestMethod.PUT , value = "/{id}") 
	public ResponseEntity<?> updateUser(@PathVariable Long id,  @RequestBody UserDto updateUser) { 
		
		try {
			UserEntity user = new UserEntity(updateUser);
			UserDto newUser = new UserDto (userService.update(user, id));
			if(user != null) {
				
			return new ResponseEntity<>(newUser, HttpStatus.OK);
				
			}
			return new ResponseEntity<RestError>(new RestError(1,"User not found"), HttpStatus.NOT_FOUND);
		}catch (Exception e) { 
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		}
	
	
}