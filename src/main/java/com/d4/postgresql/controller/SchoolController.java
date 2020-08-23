package com.d4.postgresql.controller;

import com.d4.postgresql.entities.School;
import com.d4.postgresql.service.SchoolService;
import com.d4.postgresql.util.NetworkingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	@PostMapping(path = "")
	public School createSchool(@RequestBody School school, HttpServletRequest request) {
		String userIP = NetworkingUtil.getIPFromRequest(request);
		return schoolService.createSchool(school, userIP);
	}

	@GetMapping(path = "/{id}")
	public School getSchool(@PathVariable String id) {
		return schoolService.getSchool(id);
	}

}
