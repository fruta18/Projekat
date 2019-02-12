package com.itkpreobuka.diary.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.itkpreobuka.diary.controllers.util.RestError;
import com.itkpreobuka.diary.entities.StudentEntity;
import com.itkpreobuka.diary.entities.dto.StudentDto;
import com.itkpreobuka.diary.repositories.StudentRepository;



@Service
public class StudentService implements StudentDao {

	@Autowired
	private StudentRepository studentRepository;

	public StudentEntity getById(Long id) {

		return studentRepository.getById(id);
	}
	
	
	public StudentEntity getByJmbg(String jmbg) {

		return studentRepository.getByJmbg(jmbg);
	}

	public List<StudentEntity> getAll() {

		return (List<StudentEntity>) studentRepository.findAll();
	}


/*	public  StudentEntity delete(Long id) {
		StudentEntity student = studentRepository.findById(id).get();
		if(student == null) {
			return null;
		}else {
			
			studentRepository.delete(student);
	
	return student;
	
	}
	}*/
	
	/*public ParentEntity delete(ParentEntity parent) {
		 parentRepository.delete(parent);
		 return parent;
	}*/
	
	public StudentEntity saveStudent(StudentEntity newStudent) {
		
		StudentEntity student = new StudentEntity();
		if(newStudent==null) {
			return null;
		}else {
			student.setCode(newStudent.getCode());
			student.setFirstName(newStudent.getFirstName());
			student.setLastName(newStudent.getLastName());
			student.setEmail(newStudent.getEmail());
			student.setJmbg(newStudent.getJmbg());
			student.setPhoneNumber(newStudent.getPhoneNumber());
			student.setAddress(newStudent.getAddress());
			student.setDateOfBirth(newStudent.getDateOfBirth());
			student.setGender(newStudent.getGender());
			
			return studentRepository.save(newStudent);
		}
	}
	
	public StudentEntity update(StudentEntity updateStudent, Long id) {
		StudentEntity student = studentRepository.findById(id).get();
		
		if(student == null) {
			return null;
		}else if(updateStudent == null) {
			return null;
		}else {
			student.setCode(updateStudent.getCode());
			student.setFirstName(updateStudent.getFirstName());
			student.setLastName(updateStudent.getLastName());
			student.setEmail(updateStudent.getEmail());
			student.setJmbg(updateStudent.getJmbg());
			student.setPhoneNumber(updateStudent.getPhoneNumber());
			student.setAddress(updateStudent.getAddress());
			student.setDateOfBirth(updateStudent.getDateOfBirth());
			student.setGender(updateStudent.getGender());
			student.setParents(updateStudent.getParents());
			
			return studentRepository.save(student);
		}
		}


	
	
	public boolean removeStudent(Long id) {
		StudentEntity st = studentRepository.getById(id);
		if (st!=null) {
			studentRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	
}
	


