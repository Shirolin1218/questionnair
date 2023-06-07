package com.example.questionnair.vo.request;

import java.util.List;

import com.example.questionnair.entity.Questionnaires;
import com.example.questionnair.entity.Questions;

public class QuestionnairesRequest {

	private Questionnaires questionnaire;
	
	private List<Questions> questionList;

	public Questionnaires getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaires questionnaire) {
		this.questionnaire = questionnaire;
	}

	public List<Questions> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Questions> questionList) {
		this.questionList = questionList;
	}

}
