package com.example.api_redo.controller;

import com.example.api_redo.entity.AnswerEntity;
import com.example.api_redo.service.AnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public List<AnswerEntity> find_all_answers(){return answerService.find_all_answers();
    }
    @GetMapping("/{answer_id}")
    public Optional<AnswerEntity> find_by_answer_id(@PathVariable("answer_id") Long answer_id){
        return answerService.find_by_answer_id(answer_id);
    }
    @PostMapping
    public AnswerEntity save_answer(@RequestBody AnswerEntity answerEntity){
        Long user_id = answerEntity.getUserId();
        Long survey_questionId = answerEntity.getSurvey_question_id();
        Long choiceId = answerEntity.getChoice_id();

        answerEntity.setUserId(user_id);
        answerEntity.setSurvey_question_id(survey_questionId);
        answerEntity.setChoice_id(choiceId);
        return answerService.save_answer(answerEntity);
    }
    @PutMapping("/{answer_id}")
    public AnswerEntity update_answer(@PathVariable("answer_id") Long answer_id,@RequestBody AnswerEntity answersEntity){
        answersEntity.setAnswer_id(answer_id);
        return answerService.update_answer(answersEntity);
    }

    @DeleteMapping
    public void delete_answer(@PathVariable("answer_id") Long answer_id){
        answerService.delete_answer(answer_id);
    }

}
