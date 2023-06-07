package com.example.questionnair.vo.response;

import java.util.List;

import com.example.questionnair.entity.Questionnaires;

public class QuestionnairesResponse {

	private String code;
	private String message;
	private Questionnaires questionnaire;
	private List<Questionnaires> questionnaireList;
	private int dataCount;

	public QuestionnairesResponse(String code, String message, Questionnaires questionnaire) {
		super();
		this.code = code;
		this.message = message;
		this.questionnaire = questionnaire;
	}

	public QuestionnairesResponse(String code, String message, List<Questionnaires> questionnaireList, int dataCount) {
		super();
		this.code = code;
		this.message = message;
		this.questionnaireList = questionnaireList;
		this.dataCount = dataCount;
	}

	public QuestionnairesResponse() {
	}

	public QuestionnairesResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public List<Questionnaires> getQuestionnaireList() {
		return questionnaireList;
	}

	public void setQuestionnaireList(List<Questionnaires> questionnaireList) {
		this.questionnaireList = questionnaireList;
	}

	public Questionnaires getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaires questionnaire) {
		this.questionnaire = questionnaire;
	}

}
