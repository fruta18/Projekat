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
import com.itkpreobuka.diary.entities.dto.StudentDto;
import com.itkpreobuka.diary.services.StudentService;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	/*
	 * @Autowired private ParentService parentService;
	 */
//GET BY ID
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> findStudentById(@PathVariable Long id) {
		try {
			StudentEntity student = studentService.getById(id);
			if (student != null) {
				StudentDto studentDto = new StudentDto(student);
				return new ResponseEntity<>(studentDto, HttpStatus.OK);
			}
			return new ResponseEntity<RestError>(new RestError(1, "Student not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// GET BY JMBG
	@RequestMapping(method = RequestMethod.GET, value = "/jmbg/{jmbg}")
	public ResponseEntity<?> findStudentByJmbg(@PathVariable String jmbg) {
		try {
			StudentEntity student = studentService.getByJmbg(jmbg);
			if (student != null) {
				StudentDto studentJmbg = new StudentDto(student);
				return new ResponseEntity<>(studentJmbg, HttpStatus.OK);
			}
			return new ResponseEntity<RestError>(new RestError(1, "Student not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// GET ALL STUDENTS
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudentDto>> getAll() {

		List<StudentEntity> students = studentService.getAll();
		List<StudentDto> sd = new ArrayList<>();
		for (StudentEntity s : students) {
			sd.add(new StudentDto(s));
		}
		return new ResponseEntity<>(sd, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto) {
		try {

			StudentEntity s = new StudentEntity(studentDto);
			StudentDto newStudent = new StudentDto(studentService.saveStudent(s));

			if (s != null) {

				return new ResponseEntity<>(newStudent, HttpStatus.CREATED);

			}
			return new ResponseEntity<RestError>(new RestError(1, "Creation failed"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
		try {
			if (studentService.removeStudent(id)) {

				return new ResponseEntity<RestError>(new RestError(1, "Delete successfully!"), HttpStatus.OK);
			} else {
				return new ResponseEntity<RestError>(new RestError(2, "Department not found!"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(3, "Can't delete that department"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentDto updateStudent) {

		try {
			StudentEntity s = new StudentEntity(updateStudent);
			StudentDto newStudent = new StudentDto(studentService.update(s, id));
			if (s != null) {

				return new ResponseEntity<>(newStudent, HttpStatus.OK);

			}
			return new ResponseEntity<RestError>(new RestError(1, "Student not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
/*@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	
	public ResponseEntity<?> getStudentById(@PathVariable Long id) {
		try {
			StudentEntity student = studentService.getById(id);
			if(student != null) {
					return new ResponseEntity<StudentEntity>(student, HttpStatus.OK);
				}
			return new ResponseEntity<RestError>(new RestError(1, "Student not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) { 
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	

}
