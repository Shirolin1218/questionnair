package com.example.questionnair.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private int questionId;

	@ManyToOne
	@JoinColumn(name = "questionnaire_id")
	private Questionnaires questionnaire;
	@Column(name = "title")
	private String title;
	@Column(name = "type")
	private String type;
	@Column(name = "is_required")
	private boolean isRequired;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Questionnaires getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaires questionnaire) {
		this.questionnaire = questionnaire;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRequired() {
		return isRequired;
	}

	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}

}
