package com.example.questionnair.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnair.entity.Options;
import com.example.questionnair.entity.Questionnaires;
import com.example.questionnair.entity.Questions;
import com.example.questionnair.entity.Reporters;
import com.example.questionnair.entity.Reports;

public interface ReportsDao extends JpaRepository<Reports, Integer> {

	public List<Reports> findByReporter(Reporters reporter);

	public List<Reports> findByQuestion(Questions question);

	public List<Reports> findByQuestionnaire(Questionnaires questionnaire);

	public List<Reports> findByOption(Options option);

}
