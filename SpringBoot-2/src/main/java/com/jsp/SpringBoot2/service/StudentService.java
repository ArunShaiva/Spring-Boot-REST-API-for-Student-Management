package com.jsp.SpringBoot2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.SpringBoot2.entity.Student;
import com.jsp.SpringBoot2.exceptions.StudentFoundByIdException;
import com.jsp.SpringBoot2.repository.StudentRepository;
import com.jsp.SpringBoot2.util.ResponseStructure;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;

	@Autowired
	private Student stud;

	@Autowired
	private ResponseStructure<Student> structure;

	public ResponseEntity<ResponseStructure<Student>> save(int sId,String sName, int sMarks) {

		stud.setsId(sId);
		stud.setsName(sName);
		stud.setsMarks(sMarks);

		repo.save(stud);

		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Student data saved succesfully");
		structure.setData(stud);

		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Student>> getStudentById(int sId) {
		Optional<Student> optional = repo.findById(sId);
		if (optional.isPresent()) {

			Student sid = optional.get();

			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Student Data found!!");
			structure.setData(sid);

			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);
		} else {
			throw new StudentFoundByIdException("Failed to find the Student!");
		}

	}

	public ResponseEntity<ResponseStructure<Student>> deleteStudentById(int sId) {

		Optional<Student> optional = repo.findById(sId);
		if (optional.isPresent()) {
			repo.deleteById(sId);

			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Student with ID " + sId + " deleted successfully");
			structure.setData(optional.get());

			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			throw new StudentFoundByIdException("Failed to find the Student!");
		}

	}

	public ResponseEntity<ResponseStructure<Student>> updateStudentById(int sId, Student student) {
		Optional<Student> optional = repo.findById(sId);
		if (optional.isPresent()) {
			Student existingStudent = optional.get();

			// Update the existing student's information with the new data
			existingStudent.setsName(student.getsName());
			existingStudent.setsMarks(student.getsMarks());

			// Save the updated student in the repository
			Student updatedStudent = repo.save(existingStudent);

			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Student with ID " + sId + " updated successfully");
			structure.setData(updatedStudent);

			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			throw new StudentFoundByIdException("Failed to find the Student!");
		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudentDetails() {
		List<Student> allStudents = repo.findAll();

		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Retrieved all student details");
		structure.setData(allStudents);

		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteAllStudents() {
		long countBeforeDelete = repo.count();
		repo.deleteAll();
		long countAfterDelete = repo.count();

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Deleted all students");
		structure.setData("Count before delete: " + countBeforeDelete + ", Count after delete: " + countAfterDelete);

		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
}
