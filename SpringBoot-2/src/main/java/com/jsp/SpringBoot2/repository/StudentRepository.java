package com.jsp.SpringBoot2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.SpringBoot2.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

