package com.example.api_redo.service;

import com.example.api_redo.entity.QuestionTypeEntity;


import java.util.List;
import java.util.Optional;

public interface QuestionTypeService {
    List<QuestionTypeEntity> find_all_question_types();
    Optional<QuestionTypeEntity> find_by_question_type(Long type_id);
    QuestionTypeEntity save_question_type(QuestionTypeEntity questionTypeEntity);
    QuestionTypeEntity update_question_type(QuestionTypeEntity questionTypeEntity);
    void delete_question(Long type_id);

}
