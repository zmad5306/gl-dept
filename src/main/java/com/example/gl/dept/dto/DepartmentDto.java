package com.example.gl.dept.dto;

import org.springframework.hateoas.ResourceSupport;

import com.example.gl.dept.model.Department;

public class DepartmentDto extends ResourceSupport {
	
	private Long departmentId;
	private String name;
	
	public DepartmentDto() {
		super();
	}

	public DepartmentDto(Department department) {
		super();
		if (null != department) {
			this.departmentId = department.getDepartmentId();
			this.name = department.getName();
		}
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
