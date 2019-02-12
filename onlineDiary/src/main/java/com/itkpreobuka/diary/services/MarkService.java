package com.itkpreobuka.diary.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itkpreobuka.diary.entities.DepartmentEntity;
import com.itkpreobuka.diary.entities.MarkEntity;
import com.itkpreobuka.diary.entities.StudentEntity;
import com.itkpreobuka.diary.repositories.MarkRepository;

@Service
public class MarkService implements MarkDao {

	@PersistenceContext
    EntityManager em;
	
	@Autowired
	private MarkRepository markRepository;
	
	public MarkEntity getById(Long id) {
		return markRepository.getById(id);
	}
	
	public List<MarkEntity> getAll() {

		return (List<MarkEntity>) markRepository.findAll();
	}
	
	public MarkEntity saveMark(MarkEntity newMark) {
		MarkEntity mark = new MarkEntity();
		
	if(newMark==null) {
		return null;
	}else {
		//mark.setCode(newMark.getCode());
		mark.setDateOfExamination(newMark.getDateOfExamination());
		mark.setMark(newMark.getMark());
		//mark.setListens(newMark.getListens());
		mark.setType(newMark.getType());
		//mark.setVersion(newMark.getVersion());
		mark.setBelongs(newMark.getBelongs());
		
		return markRepository.save(newMark);
		
	}
		
	}
	
	public boolean removeMark(Long id) {
	MarkEntity mark = markRepository.getById(id);
	if (mark!=null) {
		markRepository.deleteById(id);
		return true;
	}
	return false;
}
}
