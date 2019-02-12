package com.itkpreobuka.diary.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itkpreobuka.diary.controllers.util.RestError;
import com.itkpreobuka.diary.entities.SubjectEntity;
import com.itkpreobuka.diary.entities.UserEntity;
import com.itkpreobuka.diary.entities.dto.SubjectDto;
import com.itkpreobuka.diary.entities.dto.UserDto;
import com.itkpreobuka.diary.services.SubjectService;

@RestController
@RequestMapping(path="/api/v1/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	ResponseEntity<?> getSubjectById(@PathVariable Long id){
		try {
			
			SubjectEntity subject = subjectService.getById(id);
			
			if(subject!=null) {
				SubjectDto subjectdto = new SubjectDto(subject);
				return new ResponseEntity<SubjectDto>(subjectdto, HttpStatus.OK);
			}
			return new ResponseEntity<RestError>(new RestError(1, "Subject not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	//GET ALL
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SubjectDto>> getAll() {

		List<SubjectEntity> subjects = subjectService.getAll();
		List<SubjectDto> subjectdto = new ArrayList<>();
		for (SubjectEntity s : subjects) {
			subjectdto.add(new SubjectDto(s));
		}
		return new ResponseEntity<>(subjectdto, HttpStatus.OK);

	}
	
	// DELETE

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteSubject(@PathVariable Long id) {
		try {
			if(subjectService.removeSubject(id)) {
				
				return new ResponseEntity<RestError>(new RestError(1, "Delete successfully!"), HttpStatus.OK);}
			else {
				return new ResponseEntity<RestError>(new RestError(2, "Subject not found!"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(3, "Can't delete that user"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(method = RequestMethod.PUT , value = "/{id}") 
	public ResponseEntity<?> updateSubject(@PathVariable Long id,  @RequestBody SubjectDto updateSubject) { 
		
		try {
			SubjectEntity subject = new SubjectEntity(updateSubject);
			SubjectDto newSubject = new SubjectDto (subjectService.update(subject , id));
			if(subject  != null) {
				
			return new ResponseEntity<>(newSubject, HttpStatus.OK);
				
			}
			return new ResponseEntity<RestError>(new RestError(1,"Subject not found"), HttpStatus.NOT_FOUND);
		}catch (Exception e) { 
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		}
	
	
	
}
