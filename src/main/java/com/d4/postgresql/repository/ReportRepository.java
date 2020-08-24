package com.d4.postgresql.repository;

import com.d4.postgresql.entities.Report;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<Report, String> { }