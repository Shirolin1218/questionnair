package com.example.questionnair.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnair.entity.Reports;

public interface ReportsDao extends JpaRepository<Reports, Integer> {

	public List<Reports> findByReporterId(int reporterId);

	public List<Reports> findByQuestionId(int questionId);

	public List<Reports> findByQuestionnaireId(int questionnaireId);

	public List<Reports> findByOptionId(int optionId);

}
