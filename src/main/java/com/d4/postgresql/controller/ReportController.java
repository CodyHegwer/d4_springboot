package com.d4.postgresql.controller;

import com.d4.postgresql.entities.Report;
import com.d4.postgresql.entities.School;
import com.d4.postgresql.service.ReportService;
import com.d4.postgresql.service.SchoolService;
import com.d4.postgresql.util.NetworkingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ReportService reportService;

	@PostMapping(path = "")
	public Report createReport(@RequestBody Report report, HttpServletRequest request) {
		String userIP = NetworkingUtil.getIPFromRequest(request);
		return reportService.createReport(report, userIP);
	}

	// TODO: expose endpoint for getting reports for given resource id
}
