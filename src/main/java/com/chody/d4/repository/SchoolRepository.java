package com.chody.d4.repository;

import com.chody.d4.entities.School;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, String> {
}