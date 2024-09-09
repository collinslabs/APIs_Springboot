package com.example.api_redo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "answers")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long answer_id;
    // FOREIGN KEY
    @Column(name="user_id")
    private Long userId;
    // FOREIGN KEY
    @Column(name="choice_id")
    private Long choice_id;
    // FOREIGN KEY
    @Column(name = "survey_question_id")
    private Long survey_question_id;
    @Column(name="answer_value")
    private String answer_value;
    @Column(name="date_created")
    private Date date_created;
    @Column(name="date_modified")
    private Date date_modified;

    public AnswerEntity() {
    }

    public AnswerEntity(Long answer_id, UserEntity userId, ChoiceEntity choice_id, SurveyQuestionEntity survey_question_id, String answer_value, Date date_created, Date date_modified) {
        this.answer_id = answer_id;
        this.userId = userId.getUserId();
        this.choice_id = choice_id.getChoice_id();
        this.survey_question_id = survey_question_id.getSurvey_question_id();
        this.answer_value = answer_value;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }

    public Long getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Long answer_id) {
        this.answer_id = answer_id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(Long choice_id) {
        this.choice_id = choice_id;
    }

    public Long getSurvey_question_id() {
        return survey_question_id;
    }

    public void setSurvey_question_id(Long survey_question_id) {
        this.survey_question_id = survey_question_id;
    }

    public String getAnswer_value() {
        return answer_value;
    }

    public void setAnswer_value(String answer_value) {
        this.answer_value = answer_value;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(Date date_modified) {
        this.date_modified = date_modified;
    }
}
