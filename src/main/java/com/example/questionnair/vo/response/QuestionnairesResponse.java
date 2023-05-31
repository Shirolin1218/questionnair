package com.example.questionnair.vo.response;

public class QuestionnairesResponse {
	private String code;
	private String message;

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
}
