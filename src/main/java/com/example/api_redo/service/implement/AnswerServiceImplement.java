package com.example.api_redo.service.implement;

import com.example.api_redo.entity.AnswerEntity;
import com.example.api_redo.repository.AnswerRepository;
import com.example.api_redo.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImplement implements AnswerService {

    private final AnswerRepository answerRepository
            ;

    public AnswerServiceImplement(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<AnswerEntity> find_all_answers() {
        return answerRepository.findAll();
    }
    @Override
    public Optional<AnswerEntity> find_by_answer_id(Long answer_id) {
        return answerRepository.findById(answer_id);
    }

    @Override
    public AnswerEntity save_answer(AnswerEntity answerEntity) {
        return answerRepository.save(answerEntity);
    }

    @Override
    public AnswerEntity update_answer(AnswerEntity answerEntity) {
        return answerRepository.save(answerEntity);
    }

    @Override
    public void delete_answer(Long answer_id) {
        answerRepository.deleteById(answer_id);
    }
}
