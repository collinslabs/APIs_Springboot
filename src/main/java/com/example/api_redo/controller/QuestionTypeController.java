package com.example.api_redo.controller;

import com.example.api_redo.entity.QuestionTypeEntity;
import com.example.api_redo.entity.RoleEntity;
import com.example.api_redo.service.QuestionTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question_types")
public class QuestionTypeController {
    private final QuestionTypeService questionTypeService;

    public QuestionTypeController(QuestionTypeService questionTypeService) {
        this.questionTypeService = questionTypeService;
    }

    @GetMapping
    public List<QuestionTypeEntity> find_all_question_types(){
        return questionTypeService.find_all_question_types();
    }

    @GetMapping("/{type_id}")
    public Optional<QuestionTypeEntity> find_by_question_type(@PathVariable("type_id") Long type_id){
        return questionTypeService.find_by_question_type(type_id);
    }
    @PostMapping
    public QuestionTypeEntity save_question_type(@RequestBody QuestionTypeEntity questionTypeEntity){
        return questionTypeService.save_question_type(questionTypeEntity);
    }
    @PutMapping("/{type_id}")
    public QuestionTypeEntity update_question_type(@PathVariable("type_id") Long type_id, @RequestBody QuestionTypeEntity questionTypeEntity){
        questionTypeEntity.setType_id(type_id);
        return questionTypeService.update_question_type(questionTypeEntity);
    }
    @DeleteMapping("/{type_id}")
    public void delete_question_type(@PathVariable("type_id") Long type_id){
        questionTypeService.delete_question(type_id);
    }
}
