package com.example.api_redo.service;

import com.example.api_redo.entity.AnswerEntity;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    List<AnswerEntity> find_all_answers();
    Optional<AnswerEntity> find_by_answer_id(Long answer_id);
    AnswerEntity save_answer(AnswerEntity answerEntity);
    AnswerEntity update_answer(AnswerEntity answerEntity);
    void delete_answer (Long answer_id);
}
