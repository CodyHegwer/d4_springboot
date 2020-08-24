package com.d4.postgresql.service;

import com.d4.postgresql.entities.AverageRating;
import com.d4.postgresql.entities.CourseRating;

public interface CourseRatingService {
    CourseRating createCourseRating(CourseRating courseRating, String ip);
    CourseRating getRating(String id);
    AverageRating getAverageRating(String id);
}
