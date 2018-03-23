package com.example.gl.dept.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gl.dept.dto.DepartmentDto;
import com.example.gl.dept.model.Department;
import com.example.gl.dept.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	private String[] defaultDeptNames = {"Frozen", "Dairy", "Bread", "Canned"};
	private final Logger logger = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	private DepartmentRepository repo;
	
	@PostConstruct
	public void init() {
		List<String> deptNames = repo.findAll().stream().map(dept -> dept.getName()).collect(Collectors.toList());
		Arrays.asList(defaultDeptNames).stream().filter(deptName -> !deptNames.contains(deptName)).forEach(deptName -> {
			logger.info("Creating dept: " + deptName);
			Department dept = new Department(deptName);
			repo.insert(dept);
		});
		
	}
	
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
