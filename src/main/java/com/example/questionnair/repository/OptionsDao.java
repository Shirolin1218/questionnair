package com.example.questionnair.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnair.entity.Options;
import com.example.questionnair.entity.Questions;

public interface OptionsDao extends JpaRepository<Options, Integer> {

	public List<Options> findByQuestion(Questions question);
}
