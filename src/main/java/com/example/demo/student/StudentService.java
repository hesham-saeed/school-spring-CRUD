package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	

}
