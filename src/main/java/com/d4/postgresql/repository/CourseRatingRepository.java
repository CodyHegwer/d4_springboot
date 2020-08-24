package com.d4.postgresql.repository;

import com.d4.postgresql.entities.AverageRating;
import com.d4.postgresql.entities.CourseRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRatingRepository extends CrudRepository<CourseRating, String> {
    @Query(value = "SELECT ROUND(AVG(difficulty) ,1) AS difficulty, ROUND(AVG(grade) ,1) AS grade, ROUND(AVG(worth) ,1) AS worth FROM course_ratings WHERE course_id = ?1",  nativeQuery = true)
    Optional<AverageRating> getAverageRating(String courseId);
}