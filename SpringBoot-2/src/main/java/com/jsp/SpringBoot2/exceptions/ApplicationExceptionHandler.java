package com.jsp.SpringBoot2.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.SpringBoot2.util.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@Autowired
	private ErrorStructure<String> structure;

	@ExceptionHandler(StudentFoundByIdException.class)  //optional defining the class name in exception handler but it is a type safe
	
	public ResponseEntity<ErrorStructure<String>> handleStudentNotFoundById(StudentFoundByIdException ex) {

		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setRootCause("The Request User with the given id is not found");

		return new ResponseEntity<ErrorStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

}
