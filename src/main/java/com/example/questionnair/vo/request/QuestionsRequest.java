package com.example.questionnair.vo.request;

import java.util.List;

import com.example.questionnair.entity.Questions;

public class QuestionsRequest {

	private List<Questions> questionList;

	public List<Questions> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Questions> questionList) {
		this.questionList = questionList;
	}

	
}
