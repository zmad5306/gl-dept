package com.example.gl.dept.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gl.dept.dto.DepartmentDto;
import com.example.gl.dept.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/"
		)
	public List<DepartmentDto> getDepartments() {
		List<DepartmentDto> depts = this.service.getAllDepartments();
		for (DepartmentDto dept: depts) {
			Link selfLink = linkTo(DepartmentController.class).slash(dept.getDepartmentId()).withSelfRel();
			dept.add(selfLink);
		}
		return depts;
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value="/{departmentId}"
		)
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Long departmentId) {
		DepartmentDto dept = this.service.getDepartment(departmentId);
		if (null == dept) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}
		Link selfLink = linkTo(DepartmentController.class).slash(dept.getDepartmentId()).withSelfRel();
		dept.add(selfLink);
		return new ResponseEntity<>(dept, HttpStatus.OK);
	}

}
