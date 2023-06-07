package com.example.questionnair.service.ifs;

import java.util.List;

import com.example.questionnair.entity.Questionnaires;
import com.example.questionnair.entity.Questions;
import com.example.questionnair.vo.request.QuestionsRequest;
import com.example.questionnair.vo.response.QuestionsResponse;

public interface QuestionsService {
	
	public QuestionsResponse newQuestion(QuestionsRequest req);
	
	public QuestionsResponse updateQuestion(QuestionsRequest req);
	
	public QuestionsResponse delQuestion(QuestionsRequest req);
	
	public List<Questions> findByQuestionnaire(Questionnaires questionnaire);

}
