package com.example.gl.dept.repository;

import com.example.gl.dept.model.Department;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {
	
}
