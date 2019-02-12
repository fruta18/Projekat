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
import com.itkpreobuka.diary.entities.DepartmentEntity;
import com.itkpreobuka.diary.entities.ParentEntity;
import com.itkpreobuka.diary.entities.SchoolYearEntity;
import com.itkpreobuka.diary.entities.dto.DepartmentDto;
import com.itkpreobuka.diary.entities.dto.ParentDto;
import com.itkpreobuka.diary.entities.dto.SchoolYearDto;
import com.itkpreobuka.diary.services.SchoolYearService;

@RestController
@RequestMapping(path="/api/v1/schoolYear")
public class SchoolYearController {

	@Autowired 
	private SchoolYearService schoolYearService; 
	
	//GET BY ID
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> findSchoolYearById(@PathVariable Long id) {
		try {
			SchoolYearEntity schoolYear = schoolYearService.getById(id);
			if (schoolYear != null) {
				SchoolYearDto schoolYearDto = new SchoolYearDto(schoolYear);
				return new ResponseEntity<>(schoolYearDto, HttpStatus.OK);
			}
			return new ResponseEntity<RestError>(new RestError(1, "SchoolYear not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	//GET ALL
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SchoolYearDto>> getAll() {

		List<SchoolYearEntity> schoolYears = schoolYearService.getAll();
		List<SchoolYearDto> schoolYeardto = new ArrayList<>();
		for (SchoolYearEntity sy : schoolYears) {
			schoolYeardto.add(new SchoolYearDto(sy));
		}
		return new ResponseEntity<>(schoolYeardto, HttpStatus.OK);

	}
	 
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteYear(@PathVariable Long id) {
		try {
			if(schoolYearService.removeYear(id)) {
				
				return new ResponseEntity<RestError>(new RestError(1, "Delete successfully!"), HttpStatus.OK);}
			else {
				return new ResponseEntity<RestError>(new RestError(2, "Department not found!"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(3, "Can't delete that department"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT , value = "/{id}") 
	public ResponseEntity<?> updateSchoolYear(@PathVariable Long id,  @RequestBody SchoolYearDto updateSchoolYear) { 
		
		try {
			SchoolYearEntity sy= new SchoolYearEntity(updateSchoolYear);
			SchoolYearDto newSchoolYear = new SchoolYearDto (schoolYearService.update(sy, id));
			if(sy != null) {
				
			return new ResponseEntity<>(newSchoolYear, HttpStatus.OK);
				
			}
			return new ResponseEntity<RestError>(new RestError(1,"Department not found"), HttpStatus.NOT_FOUND);
		}catch (Exception e) { 
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createSchoolYear(@RequestBody SchoolYearDto schoolYearDto) {
		try {
			SchoolYearEntity sy = new SchoolYearEntity(schoolYearDto);
			SchoolYearDto newSchoolYear = new SchoolYearDto(schoolYearService.saveSchoolYear(sy));
			if (sy != null) {
				return new ResponseEntity<>(newSchoolYear, HttpStatus.CREATED);
			}
			return new ResponseEntity<RestError>(new RestError(1, "Creation failed"), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
