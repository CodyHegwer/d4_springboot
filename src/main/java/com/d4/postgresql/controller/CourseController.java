package com.d4.postgresql.controller;

import com.d4.postgresql.entities.Course;
import com.d4.postgresql.service.CourseService;
import com.d4.postgresql.util.NetworkingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping(path = "")
	public Course createCourse(@RequestBody Course course, HttpServletRequest request) {
		String userIP = NetworkingUtil.getIPFromRequest(request);
		return courseService.createCourse(course, userIP);
	}

	@GetMapping(path = "/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}

}
