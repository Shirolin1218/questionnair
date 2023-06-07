package com.example.questionnair.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.questionnair.entity.Questionnaires;
import com.example.questionnair.entity.Questions;

public interface QuestionsDao extends JpaRepository<Questions, Integer> {

	public List<Questions> findByQuestionnaire(Questionnaires questionnaire);

	@Query(value = "select * from questionnaire.questions where title = ?1 and questionnaire_id = ?2", nativeQuery = true)
	public Questions findByTitleAndQuestionnaireId(String title, int questionnaireId);

}
