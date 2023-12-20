package com.jsp.login.service;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.login.entity.Login;
import com.jsp.login.exception.InvalidPasswordException;
import com.jsp.login.exception.UnmatchedPasswordException;
import com.jsp.login.repository.LoginRepo;

import com.jsp.login.util.ResponseStructure;

@Service
public class LoginService {

	@Autowired
	private LoginRepo repo;

	@Autowired
	private Login login;

	@Autowired
	private ResponseStructure<Login> structure;

	public ResponseEntity<ResponseStructure<Login>> singIn(String userName, String password, String confirmPassword) {

		if (password.length() >= 8) {
			int caps = 0, special = 0, number = 0, small = 0;
			for (int i = 0; i < password.length(); i++) {
				char c = password.charAt(i);

				if (c >= 'A' && c <= 'Z') {
					caps++;
				} else if (c >= 'a' && c <= 'z') {
					small++;
				} else if (c >= '0' && c <= '9') {
					number++;
				} else {
					special++;
				}
			}

			if (caps > 0 && small > 0 && special > 0 && number > 0) {

				if (password.equals(confirmPassword)) {
					login.setConfirmPassword(confirmPassword);
					login.setPassword(password);
					login.setUserName(userName);
					Login save = repo.save(login);
					structure.setStatus(HttpStatus.CREATED.value());
					structure.setMsg("login successful");
					structure.setData(save);
					return new ResponseEntity<ResponseStructure<Login>>(structure, HttpStatus.CREATED);
				} else {
					throw new UnmatchedPasswordException("Check the entered password");
				}
			} else {
				throw new InvalidPasswordException("Invalid Password");
			}
		} else {
			throw new InvalidPasswordException("Password Length must be equal or greater then 8 charater");
		}
	}

}
