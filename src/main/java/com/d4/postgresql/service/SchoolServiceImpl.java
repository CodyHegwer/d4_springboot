package com.d4.postgresql.service;

import com.d4.postgresql.entities.School;
import com.d4.postgresql.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public School createSchool(School school) {

        // validation
        if ( school.getName() == null || school.getName().isBlank() || school.getName().isEmpty() ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "School must have a name");
        }

        // remove excess whitespace
        school.setName(school.getName().trim());

        // see if school exists with exact name
        Optional<School> schoolOptional = schoolRepository.findSchoolByName(school.getName());
        if (schoolOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "School already exists");
        }

        school.setId(UUID.randomUUID().toString());
        return schoolRepository.save(school);
    }

    @Override
    public School getSchool(String id) {
        Optional<School> userOptional = schoolRepository.findById(id);
        if(userOptional.isPresent()){
            return userOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "School not found with id " + id);
        }
    }
}
