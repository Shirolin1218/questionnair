package com.example.questionnair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnair.entity.Questionnaires;
import com.example.questionnair.entity.Questions;
import com.example.questionnair.service.ifs.QuestionsService;
import com.example.questionnair.vo.request.QuestionsRequest;
import com.example.questionnair.vo.response.QuestionsResponse;

@CrossOrigin
@RestController
public class QuestionsController {

	@Autowired
	private QuestionsService service;

	@PostMapping("/newQuestion")
	public QuestionsResponse newQuestion(@RequestBody QuestionsRequest req) {
		return service.newQuestion(req);
	}

	@PostMapping("/updateQuestion")
	public QuestionsResponse updateQuestion(@RequestBody QuestionsRequest req) {
		return service.updateQuestion(req);
	}

	@PostMapping("/delQuestion")
	public QuestionsResponse delQuestion(@RequestBody QuestionsRequest req) {
		return service.delQuestion(req);
	}

	@PostMapping("/findQuestionsByQuestionnaire")
	public List<Questions> findQuestionsByQuestionnaire(@RequestBody Questionnaires questionnaire) {
		return service.findByQuestionnaire(questionnaire);
	}
}
