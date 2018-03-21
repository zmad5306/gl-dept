package com.example.gl.dept.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gl.dept.model.Department;
import com.example.gl.dept.model.GenericApiResponse;

@RestController
public class DepartmentController {
	
	private List<Department> departments;
	
	Long getNextId() {
		OptionalLong  max = this.departments.stream().map(d -> d.getId()).mapToLong(Long::longValue).max();
		return max.getAsLong() + 1L;
	}
	
	@PostConstruct
	public void init() {
		this.departments = new ArrayList<>();
		
		Department dept1 = new Department(1L, "Frozen");
		Department dept2 = new Department(2L, "Meat");
		Department dept3 = new Department(3L, "Dairy");
		
		this.departments.add(dept1);
		this.departments.add(dept2);
		this.departments.add(dept3);
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/"
		)
	public List<Department> getDepartments() {
		return this.departments;
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/{departmentId}"
		)
	public Department getDepartment(@PathVariable Long departmentId) {
		List<Department> filtered = this.departments.stream().filter(d -> d.getId() == departmentId).collect(Collectors.toList());
		if (filtered.size() > 0) {
			return filtered.get(0);
		} else {
			return null;
		}
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/"
		)
	public GenericApiResponse saveDepartment(@RequestBody Department department) {
		department.setId(getNextId());
		this.departments.add(department);
		return new GenericApiResponse();
	}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/{departmentId}"
		)
	public ResponseEntity<GenericApiResponse> updateDepartment(@PathVariable Long departmentId, @RequestBody Department department) {
		Department existingDepartment = getDepartment(departmentId);
		if (null != existingDepartment) {
			this.departments.remove(existingDepartment);
			this.departments.add(department);
			return new ResponseEntity<>(new GenericApiResponse(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new GenericApiResponse(false, "dept_0001", "departhemt not found"), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/{departmentId}"
		)
	public ResponseEntity<GenericApiResponse> deleteDepartment(@PathVariable Long departmentId) {
		Department existingDepartment = getDepartment(departmentId);
		if (null != existingDepartment) {
			this.departments.remove(existingDepartment);
			return new ResponseEntity<>(new GenericApiResponse(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new GenericApiResponse(false, "dept_0001", "departhemt not found"), HttpStatus.NOT_FOUND);
		}
	}

}
