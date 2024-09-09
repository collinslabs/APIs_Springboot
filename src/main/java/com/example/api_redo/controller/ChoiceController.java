package com.example.api_redo.controller;

import com.example.api_redo.entity.ChoiceEntity;
import com.example.api_redo.service.ChoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/choices")
public class ChoiceController {

    private final ChoiceService choiceService;

    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }
    @GetMapping
    public List<ChoiceEntity> find_all_by_choices() {
        return choiceService.find_all_choices();
    }

    @GetMapping("/{choice_id}")
    public Optional<ChoiceEntity> find_by_choice_id(@PathVariable("choice_id") Long choice_id){
        return choiceService.find_by_choice_id(choice_id);
    }

    @PostMapping
    public ChoiceEntity save_choice(@RequestBody ChoiceEntity choiceEntity){
        Long survey_question_id = choiceEntity.getSurvey_question_id();
        choiceEntity.setSurvey_question_id(survey_question_id);
        return choiceService.save_choice(choiceEntity);
    }
    @PutMapping("/{choice_id}")
    public  ChoiceEntity update_choice(@PathVariable("choice_id") Long choice_id, @RequestBody ChoiceEntity choiceEntity){
        choiceEntity.setChoice_id(choice_id);
        return choiceService.update_choice(choiceEntity);
    }

    @DeleteMapping("/{choice_id}")
    public void delete_choice(@PathVariable("choice_id") Long choice_id){
        choiceService.delete_choice(choice_id);
    }

}