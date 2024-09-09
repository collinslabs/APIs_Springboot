package com.example.api_redo.service.implement;





import com.example.api_redo.entity.ChoiceEntity;
import com.example.api_redo.repository.ChoiceRepository;
import com.example.api_redo.service.ChoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChoiceServiceImplement implements ChoiceService {

    private final ChoiceRepository choiceRepository;

    public ChoiceServiceImplement (ChoiceRepository choiceRepository){
        this.choiceRepository = choiceRepository;
    }

    @Override
    public List<ChoiceEntity> find_all_choices() {
        return choiceRepository.findAll();
    }

    @Override
    public Optional<ChoiceEntity> find_by_choice_id(Long choice_id) {
        return choiceRepository.findById(choice_id);
    }

    @Override
    public ChoiceEntity save_choice(ChoiceEntity choiceEntity) {
        return choiceRepository.save(choiceEntity);
    }

    @Override
    public ChoiceEntity update_choice(ChoiceEntity choiceEntity) {
        return choiceRepository.save(choiceEntity);
    }

    @Override
    public void delete_choice(Long choice_id) {choiceRepository.deleteById(choice_id);
    }
}

