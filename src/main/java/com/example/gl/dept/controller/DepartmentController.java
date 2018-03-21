package com.example.gl.dept.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gl.dept.model.Department;

@RestController
public class DepartmentController {
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/"
		)
	public ResponseEntity<List<Department>> getDepartments() {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/{departmentId}"
		)
	public ResponseEntity<Department> getDepartment(@PathVariable Long departmentId) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/"
		)
	public ResponseEntity<?> saveDepartment(@RequestBody Department department) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/{departmentId}"
		)
	public ResponseEntity<?> updateDepartment(@PathVariable Long departmentId, @RequestBody Department department) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/{departmentId}"
		)
	public ResponseEntity<?> deleteDepartment(@PathVariable Long departmentId) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
