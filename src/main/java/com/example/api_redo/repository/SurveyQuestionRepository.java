package com.example.api_redo.repository;


import com.example.api_redo.entity.SurveyQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestionEntity, Long> {
}

