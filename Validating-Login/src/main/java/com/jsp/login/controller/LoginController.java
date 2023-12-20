package com.jsp.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.login.entity.Login;
import com.jsp.login.service.LoginService;
import com.jsp.login.util.ResponseStructure;

@RestController
public class LoginController {

	@Autowired
	private LoginService service;

	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<Login>> singIn(@RequestParam String userName, String password,
			String confirmPassword) {
		return service.singIn(userName, password, confirmPassword);
	}
}
