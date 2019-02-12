package com.itkpreobuka.diary.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.itkpreobuka.diary.entities.TeacherEntity;
import com.itkpreobuka.diary.entities.UserEntity;
import com.itkpreobuka.diary.repositories.TeacherRepository;

@Service
public class TeacherService implements TeacherDao{
	
	@Autowired 
	private TeacherRepository teacherRepository;
	
	
	/*public Optional<TeacherEntity> getById(Long id){
		return teacherRepository.getById(id);
	}*/
	
	public TeacherEntity getById(Long id) {
		return teacherRepository.getById(id);
	}
	public List<TeacherEntity> getAll() {

		return (List<TeacherEntity>) teacherRepository.findAll();
	}
	
	
	
	
public TeacherEntity saveTeacher(TeacherEntity newTeacher) {
		
		TeacherEntity teacher = new TeacherEntity();
		if(newTeacher==null) {
			return null;
		}else {
			teacher.setCode(newTeacher.getCode());
			teacher.setFirstName(newTeacher.getFirstName());
			teacher.setLastName(newTeacher.getLastName());
			teacher.setEmail(newTeacher.getEmail());
			teacher.setJmbg(newTeacher.getJmbg());
			teacher.setPhoneNumber(newTeacher.getPhoneNumber());
			teacher.setAddress(newTeacher.getAddress());
			teacher.setDateOfBirth(newTeacher.getDateOfBirth());
			teacher.setGender(newTeacher.getGender());
			teacher.setOccupation(newTeacher.getOccupation());
			
			return teacherRepository.save(newTeacher);
		}
	}


	public TeacherEntity update(TeacherEntity newTeacher, Long id) {
	TeacherEntity teacher = teacherRepository.findById(id).get();
	
	if(teacher == null) {
		return null;
	}else if(newTeacher == null) {
		return null;
	}else {
		
		teacher.setCode(newTeacher.getCode());
		teacher.setFirstName(newTeacher.getFirstName());
		teacher.setLastName(newTeacher.getLastName());
		teacher.setEmail(newTeacher.getEmail());
		teacher.setJmbg(newTeacher.getJmbg());
		teacher.setPhoneNumber(newTeacher.getPhoneNumber());
		teacher.setAddress(newTeacher.getAddress());
		teacher.setDateOfBirth(newTeacher.getDateOfBirth());
		teacher.setGender(newTeacher.getGender());
		teacher.setOccupation(newTeacher.getOccupation());
		
		return teacherRepository.save(teacher);
	}
	}	
	public boolean removeTeacher(Long id) {
		TeacherEntity teacher = teacherRepository.getById(id);
		if (teacher!=null) {
			teacherRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
	
