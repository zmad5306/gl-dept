package com.example.gl.dept.model;

public class Department {
	
	private Long departmentId;
	private String name;
	
	public Department() {
		super();
	}
	public Department(Long departmentId, String name) {
		super();
		this.departmentId = departmentId;
		this.name = name;
	}

	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
