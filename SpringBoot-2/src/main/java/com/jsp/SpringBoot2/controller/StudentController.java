package com.jsp.SpringBoot2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.SpringBoot2.entity.Student;
import com.jsp.SpringBoot2.service.StudentService;
import com.jsp.SpringBoot2.util.ResponseStructure;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	Logger log = LoggerFactory.getLogger(StudentController.class);

	@PostMapping("/save/{sId}/{sName}/{sMarks}")
	public ResponseEntity<ResponseStructure<Student>> save(@PathVariable int sId, @PathVariable String sName,
			@PathVariable int sMarks) {

		return service.save(sId, sName, sMarks);
	}

	@GetMapping("/display/{sId}")
	public ResponseEntity<ResponseStructure<Student>> getStudentById(@PathVariable int sId) {
//		log.info("getStudentById Method Invoked");  // for executing only one method

		return service.getStudentById(sId);
	}

	@DeleteMapping("/delete/{sId}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudentById(@PathVariable int sId) {

		return service.deleteStudentById(sId);
	}

	@PutMapping("/update/{sId}")
	public ResponseEntity<ResponseStructure<Student>> updateStudentById(@PathVariable int sId,
			@RequestBody Student student) {
		return service.updateStudentById(sId, student);
	}

	@GetMapping("get-all")
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudentDetails() {
		return service.getAllStudentDetails();
	}

	@DeleteMapping("delete-all")
	public ResponseEntity<ResponseStructure<String>> deleteAllStudents() {
		return service.deleteAllStudents();
	}

	// public ResponseEntity<ResponseStructure<Student>> saveStudent()

}
