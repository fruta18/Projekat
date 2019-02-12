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
import com.itkpreobuka.diary.entities.SchoolYearEntity;
import com.itkpreobuka.diary.entities.SemesterEntity;
import com.itkpreobuka.diary.entities.TeacherEntity;
import com.itkpreobuka.diary.entities.dto.SchoolYearDto;
import com.itkpreobuka.diary.entities.dto.SemesterDto;
import com.itkpreobuka.diary.entities.dto.TeacherDto;
import com.itkpreobuka.diary.services.SemesterService;

@RestController
@RequestMapping(path="api/v1/semester")
public class SemesterController {

	@Autowired
	private SemesterService semesterService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SemesterDto>> getAll() {
		
		List<SemesterEntity> semesters= semesterService.getAll();
		List<SemesterDto> sd= new ArrayList<>();
		for(SemesterEntity s : semesters) {
			sd.add(new SemesterDto(s));
		}
		return new ResponseEntity<>(sd, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT , value = "/{id}") 
	public ResponseEntity<?> updateSemester(@PathVariable Long id,  @RequestBody SemesterDto updateSemester) { 
		
		try {
			SemesterEntity semester = new SemesterEntity(updateSemester);
			SemesterDto newSemester = new SemesterDto (semesterService.update(semester, id));
			if(semester != null) {
				
			return new ResponseEntity<>(newSemester, HttpStatus.OK);
				
			}
			return new ResponseEntity<RestError>(new RestError(1,"Semester not found"), HttpStatus.NOT_FOUND);
		}catch (Exception e) { 
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		}
	
	
		@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteSemester(@PathVariable Long id) {
		try {
			if(semesterService.removeParent(id)) {
				
				return new ResponseEntity<RestError>(new RestError(1, "Delete successfully!"), HttpStatus.OK);}
			else {
				return new ResponseEntity<RestError>(new RestError(2, "Semester not found!"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(3, "Can't delete that department"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
		@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createSemester(@RequestBody SemesterDto SemesterDto) {
		try {
			SemesterEntity sm = new SemesterEntity(SemesterDto);
			SemesterDto newSemester = new SemesterDto(semesterService.saveSemester(sm));
			if (sm != null) {
				return new ResponseEntity<>(newSemester, HttpStatus.CREATED);
			}
			return new ResponseEntity<RestError>(new RestError(1, "Creation failed"), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

