package com.example.gl.dept.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gl.dept.dto.DepartmentDto;
import com.example.gl.dept.model.Department;
import com.example.gl.dept.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repo;
	
	public List<DepartmentDto> getAllDepartments() {
		return repo.findAll().stream().map(dept -> new DepartmentDto(dept)).collect(Collectors.toList());
	}
	
	public DepartmentDto getDepartment(String departmentId) {
		Optional<Department> dept = repo.findById(departmentId);
		if (dept.isPresent()) {
			return new DepartmentDto(dept.get());
		} else {
			return null;
		}
	}

}
