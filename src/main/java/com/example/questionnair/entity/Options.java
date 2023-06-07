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
@Table(name = "options")
public class Options {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "option_id")
	private int optionId;
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Questions question;
	@ManyToOne
	@JoinColumn(name = "questionnaire_id")
	private Questionnaires questionnaire;
	@Column(name = "option_name")
	private String optionName;
	@Column(name = "count")
	private int count;

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public Questions getQuestion() {
		return question;
	}

	public void setQuestion(Questions question) {
		this.question = question;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Questionnaires getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaires questionnaire) {
		this.questionnaire = questionnaire;
	}

}
