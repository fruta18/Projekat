package com.itkpreobuka.diary.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itkpreobuka.diary.entities.DepartmentEntity;
import com.itkpreobuka.diary.entities.StudentEntity;
import com.itkpreobuka.diary.repositories.DepartmentRepository;

@Service
public class DepartmentService implements DepartmentDao {

	
	@Autowired
	private DepartmentRepository departmentRepository;

	
	//GET BY ID
	public DepartmentEntity getById(Long id) {
		return departmentRepository.getById(id);
	}

	//GET ALL
	public List<DepartmentEntity> getAll() {
		return (List<DepartmentEntity>) departmentRepository.findAll();
	}

/*	//GET BY CLASSNUMBER
	public DepartmentEntity getByClassNumber(Integer classNumber) {
		return departmentRepository.findByClassNumber(classNumber);
	}*/

	
	//SAVE
	
	public DepartmentEntity saveDepartment(DepartmentEntity newDepartment) {

		ArrayList<DepartmentEntity> departments = departmentRepository.findAllByDepartmentForYear(newDepartment.getDepartmentForYear());
		if (departments.size() == 0) {
			return departmentRepository.save(newDepartment);
		}
		for (DepartmentEntity d : departments) {

			if (d.getClassNumber().equals(newDepartment.getClassNumber()) && d.getClass() == newDepartment.getClass()) {
				return null;
			}
		}
		return departmentRepository.save(newDepartment);
	}

	// treba postaviti uslov ako vec postoji to odeljenje sa tim razredom !!!

	//PUT
	public DepartmentEntity update(DepartmentEntity updateDepartment, Long id) {
		DepartmentEntity department = departmentRepository.findById(id).get();

		if (department == null) {
			return null;
		} else if (updateDepartment == null) {
			return null;
		} else {
			department.setClassNumber(updateDepartment.getClassNumber());
			department.setDepartmentNumber(updateDepartment.getDepartmentNumber());

			return departmentRepository.save(department);
		}
	}
	/*@PersistenceContext
	EntityManager em;
	@Override
	public	List<DepartmentEntity> findDepartmentByTeacherId(Long teacherId){
		
		String sql = "select distinct(d) from DepartmentEntity d, TeacherTeachesSubject tt " + "where d.id = tt.departmentId and tt.teacherId = :teacherId ";
	
		Query query = em.createQuery(sql);
		query.setParameter("teacherId", teacherId);
		
		List<DepartmentEntity> result = new ArrayList<>();
		result = query.getResultList();
		return result;
	
	}*/
	
	public boolean removeDepartment(Long id) {
	DepartmentEntity dep = departmentRepository.getById(id);
	if (dep!=null) {
		departmentRepository.deleteById(id);
		return true;
	}
	return false;
}
	
}
