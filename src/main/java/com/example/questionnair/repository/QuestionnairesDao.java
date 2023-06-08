package com.example.questionnair.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnair.entity.Questionnaires;

public interface QuestionnairesDao extends JpaRepository<Questionnaires, Integer> {

	public Page<Questionnaires> findAll(Pageable pageable);

	public List<Questionnaires> findByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);

	public Questionnaires findByTitle(String title);

	public Page<Questionnaires> findBytitleContaining(String title, Pageable pageable);

	public Page<Questionnaires> findBytitleContainingAndStartDateGreaterThanEqual(String title, LocalDate startDate,
			Pageable pageable);

	public Page<Questionnaires> findBytitleContainingAndEndDateLessThanEqual(String title, LocalDate endDate,
			Pageable pageable);

	public Page<Questionnaires> findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(String title,
			LocalDate startDate, LocalDate endDate, Pageable pageable);
}
