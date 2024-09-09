package com.example.api_redo.service.implement;

import com.example.api_redo.entity.SurveyQuestionEntity;
import com.example.api_redo.repository.SurveyQuestionRepository;
import com.example.api_redo.service.SurveyQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyQuestionServiceImplement implements SurveyQuestionService {
    private final SurveyQuestionRepository surveyQuestionRepository;

    public SurveyQuestionServiceImplement (SurveyQuestionRepository surveyQuestionRepository){
        this.surveyQuestionRepository = surveyQuestionRepository;
    }

    @Override
    public List<SurveyQuestionEntity> find_all_survey_questions(){
        return surveyQuestionRepository.findAll();
    }

    @Override
    public Optional<SurveyQuestionEntity> find_by_survey_question_id(Long survey_question_id){
        return surveyQuestionRepository.findById(survey_question_id);
    }

    @Override
    public SurveyQuestionEntity save_survey_question(SurveyQuestionEntity surveyQuestionEntity){
        return surveyQuestionRepository.save(surveyQuestionEntity);
    }

    @Override
    public SurveyQuestionEntity update_survey_question(SurveyQuestionEntity surveyQuestionEntity){
        return surveyQuestionRepository.save(surveyQuestionEntity);
    }

    @Override
    public void delete_survey_question(Long survey_question_id){
        surveyQuestionRepository.deleteById(survey_question_id);
    }

}
