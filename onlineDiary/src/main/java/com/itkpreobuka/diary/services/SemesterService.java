package com.itkpreobuka.diary.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itkpreobuka.diary.entities.ParentEntity;
import com.itkpreobuka.diary.entities.SchoolYearEntity;
import com.itkpreobuka.diary.entities.SemesterEntity;
import com.itkpreobuka.diary.entities.TeacherEntity;
import com.itkpreobuka.diary.repositories.SemesterRepository;

@Service
public class SemesterService implements SemesterDao {

	@Autowired 
	private SemesterRepository semesterRepository;

	public List<SemesterEntity> getAll() {

		return (List<SemesterEntity>) semesterRepository.findAll();
	}
	
	
	public SemesterEntity update(SemesterEntity newSemester, Long id) {
	SemesterEntity semester = semesterRepository.findById(id).get();
	
	if(semester == null) {
		return null;
	}else if(newSemester == null) {
		return null;
	}else {
		semester.setStartDate(newSemester.getStartDate());
		semester.setEndDate(newSemester.getEndDate());
		semester.setOrderNumber(newSemester.getOrderNumber());
	
		return semesterRepository.save(semester);
	}
	}	
	
	public boolean removeParent(Long id) {
		SemesterEntity p = semesterRepository.getById(id);
		if (p!=null) {
			semesterRepository.deleteById(id);
			return true;
		}
		return false;
	}

			public SemesterEntity saveSemester(SemesterEntity newSemester) {
			
			SemesterEntity semester = new SemesterEntity();
			if(newSemester==null ) {
				return null;
			}else  {
				semester.setCode(newSemester.getCode());
				semester.setOrderNumber(newSemester.getOrderNumber());
				semester.setStartDate(newSemester.getStartDate());
				semester.setEndDate(newSemester.getEndDate());
				
			
				
				
				return semesterRepository.save(newSemester);
			}
}
		
}
