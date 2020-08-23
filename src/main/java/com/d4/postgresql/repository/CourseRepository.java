package com.d4.postgresql.repository;

import com.d4.postgresql.entities.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, String> {
    Optional<Course> findCourseBySchoolIdAndName(String schoolId, String name);
    Optional<Course> findCourseBySchoolIdAndSchoolCourseId(String schoolId, String schoolCourseId);
}