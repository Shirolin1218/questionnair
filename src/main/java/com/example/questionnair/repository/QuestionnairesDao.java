package com.example.questionnair.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnair.entity.Questionnaires;

public interface QuestionnairesDao extends JpaRepository<Questionnaires, Integer> {

	public Page<Questionnaires> findAll(Pageable pageable);

	public List<Questionnaires> findByStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate);
	
	public Questionnaires findByTitle(String title);
	

}
