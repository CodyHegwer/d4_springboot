package com.d4.postgresql.controller;

import com.d4.postgresql.entities.School;
import com.d4.postgresql.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	@PostMapping(path = "")
	public School createSchool(@RequestBody School school) {
		return schoolService.createSchool(school);
	}

	@GetMapping(path = "/{id}")
	public School getSchool(@PathVariable String id) {
		return schoolService.getSchool(id);
	}

}
