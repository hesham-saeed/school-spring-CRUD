package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		if (studentRepository.findStudentByEmail(student.getEmail()).isPresent())
		{
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
		//System.out.println(student);
	}

	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		if (!studentRepository.existsById(id))
		{
			throw new IllegalStateException("student with id " + id + " does not exists");
		}
		studentRepository.deleteById(id);
	}
	
	@Transactional
	public void updateStudent(Long id, String name, String email) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException(
						"student with id " + id + " does not exist"));
		if (name != null & name.length() > 0 && !student.getName().equals(name))
			student.setName(name);
		
		
		if (email != null & email.length() > 0 && !student.getEmail().equals(email))
		{
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
			if (studentOptional.isPresent())
			{
				throw new IllegalStateException("email taken");
			}
		}
		student.setEmail(email);
		
	}
	

}
