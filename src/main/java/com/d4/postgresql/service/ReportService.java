package com.d4.postgresql.service;

import com.d4.postgresql.entities.Report;

public interface ReportService {
    Report createReport(Report report, String ip);
}
