package com.d4.postgresql.service;

import com.d4.postgresql.entities.Course;
import com.d4.postgresql.repository.CourseRepository;
import com.d4.postgresql.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public Course createCourse(Course course, String ip) {

        // validation
        if ( course.getName() == null || course.getName().isBlank() || course.getName().isEmpty() ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Course must have a name");
        }
        if ( ip == null || ip.isBlank() || ip.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "IP not present");
        }
        if ( course.getSchoolId() == null || course.getSchoolId().isBlank() || course.getSchoolId().isEmpty() ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "No school provided");
        }
        if ( schoolRepository.findById(course.getSchoolId()).isEmpty() ){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "School provided doesn't exist");
        }

        // remove excess whitespace
        course.setName(course.getName().trim());

        // see if course exists with exact name for given school
        Optional<Course> courseOptional = courseRepository.findCourseBySchoolIdAndName(course.getSchoolId(), course.getName());
        if (courseOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Course already exists for given school");
        }

        // see if course exists with exact school course id for given school
        if (course.getSchoolCourseId() != null) {
            // remove excess whitespace
            course.setSchoolCourseId(course.getSchoolCourseId().trim());
            Optional<Course> courseOptional2 = courseRepository.findCourseBySchoolIdAndSchoolCourseId(course.getSchoolId(), course.getSchoolCourseId());
            if (courseOptional2.isPresent()) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Course already exists for given course id for given school");
            }
        }

        course.setId(UUID.randomUUID().toString());
        course.setIp(ip);
        Course courseReturned = courseRepository.save(course);
        return new Course(courseReturned);
    }

    @Override
    public Course getCourse(String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if(courseOptional.isPresent()){
            return new Course(courseOptional.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found with id " + id);
    }
}
