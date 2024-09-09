package com.example.api_redo.service;



import com.example.api_redo.entity.ChoiceEntity;

import java.util.List;
import java.util.Optional;

public interface ChoiceService {
    List<ChoiceEntity> find_all_choices();
    Optional<ChoiceEntity> find_by_choice_id(Long choice_id);
    ChoiceEntity save_choice(ChoiceEntity choiceEntity);
    ChoiceEntity update_choice(ChoiceEntity choiceEntity);
    void delete_choice(Long choice_id);


}