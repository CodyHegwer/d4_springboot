package com.d4.postgresql.controller;

import com.d4.postgresql.entities.AverageRating;
import com.d4.postgresql.entities.CourseRating;
import com.d4.postgresql.service.CourseRatingService;
import com.d4.postgresql.util.NetworkingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rating")
public class CourseRatingController {

	@Autowired
	private CourseRatingService courseRatingService;

	@PostMapping(path = "")
	public CourseRating createRating(@RequestBody CourseRating rating, HttpServletRequest request) {
		String userIP = NetworkingUtil.getIPFromRequest(request);
		return courseRatingService.createCourseRating(rating, userIP);
	}

	@GetMapping(path = "/individual/{id}")
	public CourseRating getRating(@PathVariable String id) {
		return courseRatingService.getRating(id);
	}

	@GetMapping(path = "/{courseId}")
	public AverageRating getAverageRating(@PathVariable String courseId) {
		return courseRatingService.getAverageRating(courseId);
	}

}
