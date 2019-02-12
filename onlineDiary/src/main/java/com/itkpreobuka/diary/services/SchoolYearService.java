package com.itkpreobuka.diary.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itkpreobuka.diary.entities.DepartmentEntity;
import com.itkpreobuka.diary.entities.SchoolYearEntity;
import com.itkpreobuka.diary.repositories.SchoolYearRepository;

@Service
public class SchoolYearService implements SchoolYearDao{

	@Autowired
	private SchoolYearRepository schoolYearRepository;
	
	
	
	// POST 
		public SchoolYearEntity saveSchoolYear(SchoolYearEntity newSchoolYear) {
			
			SchoolYearEntity schoolYear = new SchoolYearEntity();
			if(newSchoolYear==null ) {
				return null;
			}else  {
				schoolYear.setYear(newSchoolYear.getYear());
				schoolYear.setCode(newSchoolYear.getCode());
				
				
				return schoolYearRepository.save(newSchoolYear);
			}
}
		
		
		public  SchoolYearEntity getById(Long id) {
		return schoolYearRepository.getById(id);
	}
	
	public List< SchoolYearEntity> getAll() {
		return (List<SchoolYearEntity>) schoolYearRepository.findAll();
	}


	public boolean removeYear(Long id) {
	SchoolYearEntity sy = schoolYearRepository.getById(id);
	if (sy!=null) {
		schoolYearRepository.deleteById(id);
		return true;
	}
	return false;
	
}
	
	
	public SchoolYearEntity update(SchoolYearEntity updateSchoolYear, Long id) {
		SchoolYearEntity schoolYear = schoolYearRepository.findById(id).get();

		if (schoolYear == null) {
			return null;
		} else if (updateSchoolYear == null) {
			return null;
		} else {
			schoolYear.setYear(updateSchoolYear.getYear());
			schoolYear.setSemester(updateSchoolYear.getSemester());

			return schoolYearRepository.save(schoolYear);
		}
	}
}