package com.d4.postgresql.service;

import com.d4.postgresql.entities.School;

public interface SchoolService {
    School createSchool(School school, String ip);
    School getSchool(String id);
}
