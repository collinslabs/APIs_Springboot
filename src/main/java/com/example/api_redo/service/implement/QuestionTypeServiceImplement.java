package com.example.api_redo.service.implement;

import com.example.api_redo.entity.QuestionTypeEntity;
import com.example.api_redo.repository.QuestionTypeRepository;
import com.example.api_redo.service.QuestionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionTypeServiceImplement implements QuestionTypeService {
    private final QuestionTypeRepository questionTypeRepository;

    public QuestionTypeServiceImplement (QuestionTypeRepository questionTypeRepository){
        this.questionTypeRepository = questionTypeRepository;
    }


    @Override
    public List<QuestionTypeEntity> find_all_question_types() {
        return questionTypeRepository.findAll();
    }

    @Override
    public Optional<QuestionTypeEntity> find_by_question_type(Long type_id) {
        return questionTypeRepository.findById(type_id);
    }

    @Override
    public QuestionTypeEntity save_question_type(QuestionTypeEntity questionTypeEntity) {
        return questionTypeRepository.save(questionTypeEntity);
    }

    @Override
    public QuestionTypeEntity update_question_type(QuestionTypeEntity questionTypeEntity) {
        return questionTypeRepository.save(questionTypeEntity);
    }

    @Override
    public void delete_question(Long type_id) {
        questionTypeRepository.deleteById(type_id);
    }
}
