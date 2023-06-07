package com.example.questionnair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnair.entity.Questionnaires;
import com.example.questionnair.service.ifs.QuestionnairesService;
import com.example.questionnair.vo.request.QuestionnairesRequest;
import com.example.questionnair.vo.response.QuestionnairesResponse;

@CrossOrigin
@RestController
public class QuestionnairesController {

	@Autowired
	private QuestionnairesService service;

	@PostMapping("/newQuestionnaire")
	public QuestionnairesResponse newQuestionnaire(@RequestBody QuestionnairesRequest req) {
		return service.newQuestionnaire(req);
	}

	@PostMapping("/updateQuestionnaire")
	public QuestionnairesResponse updateQuestionnaire(@RequestBody QuestionnairesRequest req) {
		return service.updateQuestionnaire(req);
	}

	@GetMapping("/getHowManyData")
	public QuestionnairesResponse getHowManyData() {
		return service.getHowManyData();
	}

	@PostMapping("/findQuestionnairesPage")
	public List<Questionnaires> findQuestionnairesPage(@RequestBody int page) {
		return service.findQuestionnairesPage(PageRequest.of(page, 10));
	}

	@PostMapping("/findByTitle")
	public QuestionnairesResponse findByTitle(@RequestBody String title) {
		return service.findByTitle(title);
	}

}
