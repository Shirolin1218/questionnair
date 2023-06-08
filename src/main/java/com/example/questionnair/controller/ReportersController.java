package com.example.questionnair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnair.service.ifs.ReportersService;
import com.example.questionnair.vo.request.ReportersRequest;
import com.example.questionnair.vo.response.ReportersResponse;

@CrossOrigin
@RestController
public class ReportersController {
	
	@Autowired
	private ReportersService service;

	@PostMapping("/newReporter")
	public ReportersResponse newReporter(@RequestBody ReportersRequest req) {
		return service.newReporter(req);
	}
}
