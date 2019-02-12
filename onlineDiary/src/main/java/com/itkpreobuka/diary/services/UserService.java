package com.itkpreobuka.diary.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itkpreobuka.diary.entities.DepartmentEntity;
import com.itkpreobuka.diary.entities.UserEntity;
import com.itkpreobuka.diary.repositories.ParentRepository;
import com.itkpreobuka.diary.repositories.StudentRepository;
import com.itkpreobuka.diary.repositories.TeacherRepository;
import com.itkpreobuka.diary.repositories.UserRepository;



@Service
public class UserService implements UserDao{

	
	@Autowired
	private UserRepository userRepository;
	
/*	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ParentRepository parentRepository;
	
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public List<String>findAllEmails(){
		String sql1="select email from TeacherEntity";
		String sql2="select email from StudenEntity";
		String sql3="select email from ParentEntity";
		Query q1=em.createQuery(sql1);
		Query q2=em.createQuery(sql2);
		Query q3=em.createQuery(sql3);
		List<String>result1=new ArrayList<>();
		List<String>result2=new ArrayList<>();
		List<String>result3=new ArrayList<>();
		List<String>results= new ArrayList<>();
		results.addAll(result1);
		results.addAll(result2);
		results.addAll(result3);
		return results;
		
		
		
		
	}*/
	
	public UserEntity getById(Long id) {
		return userRepository.getById(id);
		
	}

	public List<UserEntity> getAll() {

		return (List<UserEntity>) userRepository.findAll();
	}
	
	public Optional<UserEntity> findUserByUsername(String email) {
		return userRepository.findUserByUsername(email);
	}

	public boolean removeUser(Long id) {
		UserEntity user = userRepository.getById(id);
		if (user!=null) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public UserEntity update(UserEntity updateUser, Long id) {
		UserEntity user = userRepository.findById(id).get();

		if (user == null) {
			return null;
		} else if (updateUser == null) {
			return null;
		} else {
			user.setUsername(updateUser.getUsername());
			user.setPassword(updateUser.getPassword());
			user.setRepeatedPassword(updateUser.getRepeatedPassword());
			user.setRoles(updateUser.getRoles());

			return userRepository.save(user);
		}
	}
	
}
