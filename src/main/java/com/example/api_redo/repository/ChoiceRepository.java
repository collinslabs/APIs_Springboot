package com.example.api_redo.repository;

import com.example.api_redo.entity.ChoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ChoiceRepository extends JpaRepository<ChoiceEntity, Long> {

}