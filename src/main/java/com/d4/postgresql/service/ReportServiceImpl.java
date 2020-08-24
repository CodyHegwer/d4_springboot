package com.d4.postgresql.service;

import com.d4.postgresql.entities.Report;
import com.d4.postgresql.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report createReport(Report report, String ip) {

        // validation
        if ( report.getResourceId() == null || report.getResourceId().isBlank() || report.getResourceId().isEmpty() ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Report must have a corresponding resource id");
        }
        if ( report.getReason() == null ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Report must have a reason");
        }
        if ( report.getResourceType() == null ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Report must have a resource type");
        }
        if ( ip == null || ip.isBlank() || ip.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "IP not present");
        }

        // TODO: validate resource exists with resource id

        report.setId(UUID.randomUUID().toString());
        report.setIp(ip);
        report.setSubmitDate(Instant.now());
        return new Report(reportRepository.save(report));
    }
}
