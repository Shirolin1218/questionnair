package com.example.questionnair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnair.entity.Options;
import com.example.questionnair.entity.Questions;
import com.example.questionnair.service.ifs.OptionsService;
import com.example.questionnair.vo.request.OptionsRequest;
import com.example.questionnair.vo.response.OptionsResponse;

@CrossOrigin
@RestController
public class OptionsController {
	@Autowired
	private OptionsService service;

	@PostMapping("/newOption")
	public OptionsResponse newOption(@RequestBody OptionsRequest req) {
		return service.newOption(req);
	}

	@PostMapping("/updateOption")
	public OptionsResponse updateOption(@RequestBody OptionsRequest req) {
		return service.updateOption(req);
	}

	@PostMapping("/delOption")
	public OptionsResponse delOption(@RequestBody OptionsRequest req) {
		return service.delOption(req);
	}

	@PostMapping("/findByQuestions")
	public List<Options> findByQuestions(@RequestBody Questions question) {
		return service.findByQuestion(question);
	}
}
