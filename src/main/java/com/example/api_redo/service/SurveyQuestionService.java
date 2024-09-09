package com.example.api_redo.service;




import com.example.api_redo.entity.SurveyEntity;
import com.example.api_redo.entity.SurveyQuestionEntity;

import java.util.List;
import java.util.Optional;

public interface SurveyQuestionService {
    List<SurveyQuestionEntity> find_all_survey_questions();
    Optional<SurveyQuestionEntity> find_by_survey_question_id(Long survey_question_id);
    SurveyQuestionEntity save_survey_question(SurveyQuestionEntity surveyQuestionEntity);
    SurveyQuestionEntity update_survey_question(SurveyQuestionEntity surveyQuestionEntity);
    void delete_survey_question(Long survey_question_id);
}
