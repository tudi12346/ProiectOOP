package com.accommodation.service;

import java.util.List;

import com.accommodation.model.Student;
import com.accommodation.repository.StudentRepository;

public class StudentService implements Service<Student> {

	private StudentRepository studentRepository = new StudentRepository();

	@Override
	public Student save(Student entity) {
		return studentRepository.save(entity);
	}

	@Override
	public Student findById(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public boolean delete(Student entity) {
		return studentRepository.delete(entity);
	}

	@Override
	public boolean deleteById(Long id) {
		return studentRepository.deleteById(id);
	}

}
