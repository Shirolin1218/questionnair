package com.example.questionnair.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reports")
public class Reports {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private int reportId;
	@ManyToOne
	@JoinColumn(name = "reporter_id")
	private Reporters reporter;
	@ManyToOne
	@JoinColumn(name = "option_id")
	private Options option;
	@ManyToOne
	@JoinColumn(name = "questionnaire_id")
	private Questionnaires questionnaire;
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Questions question;
	@Column(name = "report_time")
	private LocalDateTime reportTime = LocalDateTime.now();

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public Reporters getReporter() {
		return reporter;
	}

	public void setReporter(Reporters reporter) {
		this.reporter = reporter;
	}

	public Options getOption() {
		return option;
	}

	public void setOption(Options option) {
		this.option = option;
	}

	public Questionnaires getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaires questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Questions getQuestion() {
		return question;
	}

	public void setQuestion(Questions question) {
		this.question = question;
	}

	public LocalDateTime getReportTime() {
		return reportTime;
	}

	public void setReportTime(LocalDateTime reportTime) {
		this.reportTime = reportTime;
	}

}
