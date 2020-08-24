package com.d4.postgresql.service;

import com.d4.postgresql.entities.AverageRating;
import com.d4.postgresql.entities.CourseRating;
import com.d4.postgresql.repository.CourseRatingRepository;
import com.d4.postgresql.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CourseRatingServiceImpl implements CourseRatingService {

    @Autowired
    private CourseRatingRepository courseRatingRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseRating createCourseRating(CourseRating courseRating, String ip) {

        // validation
        if ( courseRating.getDifficulty() == null ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Rating must have a difficulty value");
        }
        if ( courseRating.getDifficulty() < 1 || courseRating.getDifficulty() > 10) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Difficulty must be within 1-10");
        }
        if ( courseRating.getWorth() != null && ( courseRating.getWorth() < 1 || courseRating.getWorth() > 10) ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Worth must be within 1-10");
        }
        if ( courseRating.getGrade() != null && ( courseRating.getGrade() < 0 || courseRating.getGrade() > 100) ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Grade must be within 0-100");
        }
        if ( ip == null || ip.isBlank() || ip.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "IP not present");
        }
        if ( courseRating.getCourseId() == null || courseRating.getCourseId().isBlank() || courseRating.getCourseId().isEmpty() ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "No course id provided");
        }
        if ( courseRepository.findById(courseRating.getCourseId()).isEmpty() ){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Course id provided doesn't exist");
        }

        // TODO: check if rating already submitted for IP

        courseRating.setId(UUID.randomUUID().toString());
        courseRating.setIp(ip);
        return new CourseRating(courseRatingRepository.save(courseRating));
    }

    @Override
    public CourseRating getRating(String id) {
        // TODO: implement individual record retrieval
        return null;
    }

    @Override
    public AverageRating getAverageRating(String id) {
        Optional<AverageRating> rating = courseRatingRepository.getAverageRating(id);
        if (rating.isPresent()) {
            return rating.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Average rating not found for course id " + id);
    }
}
