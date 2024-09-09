package com.example.api_redo.controller;

import com.example.api_redo.entity.SurveyEntity;
import com.example.api_redo.handler.ResponseHandler;
import com.example.api_redo.service.SurveyService;
import com.example.api_redo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/surveys")
@CrossOrigin(origins = "*")
public class SurveyController {

    private final SurveyService surveyService;
    private final UserService userService;

    public SurveyController (SurveyService surveyService, UserService userService){
        this.surveyService = surveyService;
        this.userService = userService;
    }

    @GetMapping
    public List<SurveyEntity> find_all_surveys(){
        return surveyService.find_all_surveys();
    }

    @GetMapping("/{survey_id}")
    public Optional<SurveyEntity> find_by_survey_id(@PathVariable("survey_id") Long survey_id){
        return surveyService.find_by_survey_id(survey_id);
    }

    @PostMapping
    public ResponseEntity<Object> save_survey(@RequestBody SurveyEntity surveyEntity) {


        SurveyEntity savedSurvey = surveyService.save_survey(surveyEntity);
        return ResponseHandler.generate_response("Survey saved successfully!", HttpStatus.CREATED, savedSurvey);
    }

    @PutMapping("/{survey_id}")
    public SurveyEntity update_survey(@PathVariable Long survey_id, @RequestBody SurveyEntity surveyEntity){
        surveyEntity.setSurveyId(survey_id);
        return surveyService.update_survey(surveyEntity);
    }

    @DeleteMapping("/{survey_id}")
    public void delete_survey(@PathVariable("survey_id") Long survey_id){
        surveyService.delete_survey(survey_id);
    }


}
