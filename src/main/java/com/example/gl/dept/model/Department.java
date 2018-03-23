package com.example.gl.dept.model;

import org.springframework.data.annotation.Id;

public class Department {
	
	@Id
	private String departmentId;
	private String name;
	
	public Department() {
		super();
	}
	public Department(String name) {
		super();
		this.name = name;
	}

	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
