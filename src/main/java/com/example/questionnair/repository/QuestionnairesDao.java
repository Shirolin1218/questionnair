package com.example.questionnair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnair.entity.Questionnaires;

public interface QuestionnairesDao extends JpaRepository<Questionnaires, Integer> {

}
