package com.jsp.login.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.jsp.login.exception.InvalidPasswordException;
import com.jsp.login.exception.UnmatchedPasswordException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@Autowired
	private ErrorStructure<String> error;

	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ErrorStructure<String>> handleInvalidPassword(InvalidPasswordException exception) {
		error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		error.setMsg(exception.getMsg());
		error.setRootCause("Password Not Matching with the Eligibilty criteria");
		return new ResponseEntity<ErrorStructure<String>>(error, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(UnmatchedPasswordException.class)
	public ResponseEntity<ErrorStructure<String>> handleUnmatchedPassword(UnmatchedPasswordException exception) {
		error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		error.setMsg(exception.getMsg());
		error.setRootCause("Confirm password not matching with the Entered Password");
		return new ResponseEntity<ErrorStructure<String>>(error, HttpStatus.NOT_ACCEPTABLE);
	}

}
