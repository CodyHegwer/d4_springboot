package com.d4.postgresql.repository;

import com.d4.postgresql.entities.School;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SchoolRepository extends CrudRepository<School, String> {
    Optional<School> findSchoolByName(String name);
}