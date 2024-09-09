package com.example.api_redo.service;

import com.example.api_redo.entity.SurveyEntity;

import java.util.List;
import java.util.Optional;

public interface SurveyService {
    List<SurveyEntity> find_all_surveys();
    Optional<SurveyEntity> find_by_survey_id(Long survey_id);
    SurveyEntity save_survey(SurveyEntity surveyEntity);
    SurveyEntity update_survey(SurveyEntity surveyEntity);
    void delete_survey(Long survey_id);

}
