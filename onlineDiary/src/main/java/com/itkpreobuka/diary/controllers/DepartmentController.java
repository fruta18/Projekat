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
import com.itkpreobuka.diary.entities.SchoolYearEntity;
import com.itkpreobuka.diary.entities.StudentEntity;
import com.itkpreobuka.diary.entities.TeacherEntity;
import com.itkpreobuka.diary.entities.UserEntity;
import com.itkpreobuka.diary.entities.dto.DepartmentDto;
import com.itkpreobuka.diary.entities.dto.StudentDto;
import com.itkpreobuka.diary.services.DepartmentDao;
import com.itkpreobuka.diary.services.DepartmentService;
import com.itkpreobuka.diary.services.SchoolYearService;

@RestController
@RequestMapping(path="api/v1/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private SchoolYearService schoolYearService;
	
	//GET BY ID
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> findDepartmentById(@PathVariable Long id) {
		try {
			DepartmentEntity department = departmentService.getById(id);
			if (department != null) {
				DepartmentDto departmentDto = new DepartmentDto(department);
				return new ResponseEntity<>(departmentDto, HttpStatus.OK);
			}
			return new ResponseEntity<RestError>(new RestError(1, "Department not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	/*//GET BY CLASSNUMBER
	
		@RequestMapping(method = RequestMethod.GET, value = "classNumber/{classNumber}")
	public ResponseEntity<?> findDepartmentByClassNumber(@PathVariable Integer classNumber) {
		try {
			DepartmentEntity department = departmentService.getByClassNumber(classNumber);
			if (department != null) {
				DepartmentDto departmentDto = new DepartmentDto(department);
				return new ResponseEntity<>(departmentDto, HttpStatus.OK);
			}
			return new ResponseEntity<RestError>(new RestError(1, "Department not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} */
	//GET ALL
	 @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DepartmentDto>> getAll() {

		List<DepartmentEntity> departments = departmentService.getAll();
		List<DepartmentDto> departmentdto = new ArrayList<>();
		for (DepartmentEntity d : departments) {
			departmentdto.add(new DepartmentDto(d));
		}
		return new ResponseEntity<>(departmentdto, HttpStatus.OK);

	}
	 
	 //POST
	 
	/* @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentDto departmentDto) {
		try{
			
			SchoolYearEntity schoolYear = schoolYearService.getSchoolYearById(departmentDto.getDepartmentForYear());
		DepartmentEntity d = new DepartmentEntity(departmentDto);
		DepartmentDto newDepartment = new DepartmentDto(departmentService.saveDepartment(d));
		
		if(d!=null) {
			
			return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
			
			}	return new ResponseEntity<RestError>(new RestError(1, "Creation failed"), HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

			
	}
	 }*/
	@RequestMapping(method = RequestMethod.PUT , value = "/{id}") 
	public ResponseEntity<?> updateDepartment(@PathVariable Long id,  @RequestBody DepartmentDto updateDepartment) { 
		
		try {
			DepartmentEntity d= new DepartmentEntity(updateDepartment);
			DepartmentDto newDepartment = new DepartmentDto (departmentService.update(d, id));
			if(d != null) {
				
			return new ResponseEntity<>(newDepartment, HttpStatus.OK);
				
			}
			return new ResponseEntity<RestError>(new RestError(1,"Department not found"), HttpStatus.NOT_FOUND);
		}catch (Exception e) { 
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		}

	
/*	@RequestMapping(method = RequestMethod.GET, value = "/teacher/{teacherId}")
	public ResponseEntity<?> getDepartmentByTeacherId(@PathVariable Long teacherId) {
		
		
		
	List<DepartmentEntity> departments = departmentService.findDepartmentByTeacherId(teacherId);
		List<DepartmentDto> departmentdto = new ArrayList<>();
		for (DepartmentEntity d : departments) {
			departmentdto.add(new DepartmentDto(d));
		}
		
		return new ResponseEntity<>(departmentdto, HttpStatus.OK);
	}
	
	
*/	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
		try {
			if(departmentService.removeDepartment(id)) {
				
				return new ResponseEntity<RestError>(new RestError(1, "Delete successfully!"), HttpStatus.OK);}
			else {
				return new ResponseEntity<RestError>(new RestError(2, "Department not found!"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(3, "Can't delete that department"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

