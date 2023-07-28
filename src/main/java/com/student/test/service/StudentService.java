package com.student.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.test.dao.StudentRepository;
import com.student.test.entites.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public Student addStudent(Student student)
	{
		Student save = repository.save(student);
		return save;
	}
	
	public Iterable<Student> allStudent()
	{
		return repository.findAll();
	}
	
	public void deleteStudent(int id)
	{
		repository.deleteById(id);
	}
	
	public Student getById(int id)
	{
		Student s = repository.findById(id).get();
		return s; 
	}
	
	public Student update(Student s)
	{
		Student student = repository.findById(s.getId()).get();
		student.setName(s.getName());
		student.setStandard(s.getStandard());
		student.setAddress(s.getAddress());
		student.setPhoneNo(s.getPhoneNo());
		Student result = repository.save(student);
		return result;
	}
}
