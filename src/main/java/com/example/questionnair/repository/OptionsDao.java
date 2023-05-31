package com.example.questionnair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnair.entity.Options;

public interface OptionsDao extends JpaRepository<Options, Integer>{

}
