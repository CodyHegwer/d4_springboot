package com.d4.postgresql.service;

import com.d4.postgresql.entities.Course;

public interface CourseService {
    Course createCourse(Course course, String ip);
    Course getCourse(String id);
}
