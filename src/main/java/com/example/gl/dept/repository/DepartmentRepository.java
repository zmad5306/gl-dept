package com.example.gl.dept.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.example.gl.dept.model.Department;

@Repository
public class DepartmentRepository {
	
	private List<Department> departments;
	
	Department findDepartment(Long departmentId) {
		List<Department> matchingDepts = this.departments.stream().filter(dept -> dept.getDepartmentId().equals(departmentId)).collect(Collectors.toList());
		if (matchingDepts.isEmpty()) {
			return null;
		} else {
			return matchingDepts.get(0);
		}
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
	
	public List<Department> fetchAll() {
		return this.departments;
	}
	
	public Department fetch(Long departmentId) {
		return findDepartment(departmentId);	
	}
	
}
