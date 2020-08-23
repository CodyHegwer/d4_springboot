package com.chody.d4.service;

import com.chody.d4.entities.School;
import com.chody.d4.repository.SchoolRepository;
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
