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
import com.itkpreobuka.diary.entities.StudentEntity;
import com.itkpreobuka.diary.entities.TeacherEntity;
import com.itkpreobuka.diary.entities.UserEntity;
import com.itkpreobuka.diary.entities.dto.StudentDto;
import com.itkpreobuka.diary.entities.dto.TeacherDto;
import com.itkpreobuka.diary.entities.dto.UserDto;
import com.itkpreobuka.diary.services.TeacherService;

@RestController
@RequestMapping(path= "/api/v1/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	
	/*@RequestMapping(method = RequestMethod.GET, value = "/{id}")

	public ResponseEntity<?> getTeacherByID(@PathVariable Long id) {
		try {
			Optional<TeacherEntity> teacher=teacherService.getById(id);
			
				if (teacher!=null) {
					return new ResponseEntity<TeacherDto>(new TeacherDto(teacher.get()), HttpStatus.OK);
				}
			
			return new ResponseEntity<RestError>(new RestError(1, "User not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}*/
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> findTeacherById(@PathVariable Long id) {
		try {
			TeacherEntity teacher = teacherService.getById(id);
			if (teacher != null) {
				TeacherDto teacherDto = new TeacherDto(teacher);
				return new ResponseEntity<>(teacherDto, HttpStatus.OK);
			}
			return new ResponseEntity<RestError>(new RestError(1, "Teacher not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TeacherDto>> getAll() {
		
		List<TeacherEntity> teachers= teacherService.getAll();
		List<TeacherDto> td= new ArrayList<>();
		for(TeacherEntity t : teachers) {
			td.add(new TeacherDto(t));
		}
		return new ResponseEntity<>(td, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createTeacher(@RequestBody TeacherDto teacherDto) {
		try {
			TeacherEntity t = new TeacherEntity(teacherDto);
			TeacherDto newTeacher = new TeacherDto(teacherService.saveTeacher(t));
			if (t != null) {
				return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
			}
			return new ResponseEntity<RestError>(new RestError(1, "Creation failed"), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteTeacher(@PathVariable Long id) {
		try {
			if(teacherService.removeTeacher(id)) {
				
				return new ResponseEntity<RestError>(new RestError(1, "Delete successfully!"), HttpStatus.OK);}
			else {
				return new ResponseEntity<RestError>(new RestError(2, "Teacher not found!"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(3, "Can't delete that user"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT , value = "/{id}") 
	public ResponseEntity<?> updateTeacher(@PathVariable Long id,  @RequestBody TeacherDto updateTeacher) { 
		
		try {
			TeacherEntity teacher = new TeacherEntity(updateTeacher);
			TeacherDto newTeacher = new TeacherDto (teacherService.update(teacher, id));
			if(teacher != null) {
				
			return new ResponseEntity<>(newTeacher, HttpStatus.OK);
				
			}
			return new ResponseEntity<RestError>(new RestError(1,"Teacher not found"), HttpStatus.NOT_FOUND);
		}catch (Exception e) { 
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		}

}
