package com.example.api_redo.service.implement;

import com.example.api_redo.entity.SurveyEntity;
import com.example.api_redo.repository.SurveyRepository;
import com.example.api_redo.service.SurveyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImplement implements SurveyService {
    private final SurveyRepository surveyRepository;

    public SurveyServiceImplement (SurveyRepository surveyRepository){
        this.surveyRepository = surveyRepository;
    }

    @Override
    public List<SurveyEntity> find_all_surveys(){
        return surveyRepository.findAll();
    }

    @Override
    public Optional<SurveyEntity> find_by_survey_id(Long survey_id){
        return surveyRepository.findById(survey_id);
    }

    @Override
    public SurveyEntity save_survey(SurveyEntity surveyEntity){
        return surveyRepository.save(surveyEntity);
    }

    @Override
    public SurveyEntity update_survey(SurveyEntity surveyEntity){
        return surveyRepository.save(surveyEntity);
    }

    @Override
    public void delete_survey(Long survey_id){
        surveyRepository.deleteById(survey_id);
    }

}
