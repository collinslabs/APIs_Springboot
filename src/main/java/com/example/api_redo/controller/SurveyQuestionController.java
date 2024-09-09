package com.example.api_redo.controller;

import com.example.api_redo.entity.SurveyQuestionEntity;
import com.example.api_redo.entity.UserEntity;
import com.example.api_redo.service.SurveyQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/survey_questions")
public class SurveyQuestionController {

    private final SurveyQuestionService surveyQuestionService;

    public SurveyQuestionController (SurveyQuestionService surveyQuestionService){
        this.surveyQuestionService = surveyQuestionService;
    }

    @GetMapping
    public List<SurveyQuestionEntity> find_all_survey_questions(){
        return surveyQuestionService.find_all_survey_questions();
    }


    @GetMapping("/{survey_question_id}")
    public Optional<SurveyQuestionEntity> find_by_survey_question_id(@PathVariable("survey_question_id") Long survey_question_id){
        return surveyQuestionService.find_by_survey_question_id(survey_question_id);
    }
    @PostMapping
    public SurveyQuestionEntity save_survey_question(Long survey_question_id, @RequestBody SurveyQuestionEntity surveyQuestionEntity){
        return surveyQuestionService.save_survey_question(surveyQuestionEntity);
    }

    @PutMapping("/{survey_question_id}")
    public SurveyQuestionEntity update_survey_question(@PathVariable("survey_question_id") Long survey_question_id, @RequestBody SurveyQuestionEntity surveyQuestionEntity){
        return surveyQuestionService.update_survey_question(surveyQuestionEntity);
    }


    @DeleteMapping("/{survey_question_id}")
    public void delete_survey(@PathVariable("survey_question_id") Long survey_question_id){
        surveyQuestionService.delete_survey_question(survey_question_id);
    }


}
