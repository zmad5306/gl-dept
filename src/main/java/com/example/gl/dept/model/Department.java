package com.example.gl.dept.model;

public class Department {
	
	private Long id;
	private String name;
	
	public Department() {
		super();
	}
	public Department(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
