package com.example.questionnair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnair.entity.Questions;

public interface QuestionsDao extends JpaRepository<Questions, Integer>{

}
