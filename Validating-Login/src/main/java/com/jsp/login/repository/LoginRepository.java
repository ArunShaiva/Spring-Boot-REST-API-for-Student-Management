package com.jsp.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jsp.login.entity.Login;

@Component
public interface LoginRepository extends JpaRepository<Login, Integer> {

}
