package com.itkpreobuka.diary.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itkpreobuka.diary.entities.SubjectEntity;
import com.itkpreobuka.diary.entities.UserEntity;
import com.itkpreobuka.diary.repositories.SubjectRepository;

@Service
public class SubjectService implements SubjectDao {

	@Autowired
	private SubjectRepository subjectRepository;
	
	public  SubjectEntity getById(Long id) {
		return  subjectRepository.getById(id);
		
	}

	public List< SubjectEntity> getAll() {

		return (List< SubjectEntity>)  subjectRepository.findAll();
	}
	
	
	public boolean removeSubject(Long id) {
		SubjectEntity subject = subjectRepository.getById(id);
		if (subject!=null) {
			subjectRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public SubjectEntity update(SubjectEntity updateSubject, Long id) {
		SubjectEntity subject = subjectRepository.findById(id).get();

		if (subject == null) {
			return null;
		} else if (updateSubject == null) {
			return null;
		} else {
			subject.setFond(updateSubject.getFond());
			subject.setName(updateSubject.getName());
			subject.setSchoolYear(updateSubject.getSchoolYear());

			return subjectRepository.save(subject);
		}
	}
	
	
	
}
	

