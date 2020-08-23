package com.chody.d4.service;

import com.chody.d4.entities.School;

public interface SchoolService {
    School createSchool(School school);
    School getSchool(String id);
}
