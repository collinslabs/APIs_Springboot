package com.example.api_redo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "survey_questions")
public class SurveyQuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_question_id")
    private Long survey_question_id;
    //FOREIGN KEY
    @Column(name = "survey_id")
    private Long survey_id;
    @Column(name = "type_id")
    private Long type_id;
    @Column(name = "question")
    private String question;
    @Column(name = "date_created")
    private Date date_created;
    @Column(name = "date_modified")
    private Date date_modified;

    public SurveyQuestionEntity() {
    }

    public SurveyQuestionEntity(Long survey_question_id, SurveyEntity survey_id, Long type_id, String question, Date date_created, Date date_modified) {
        this.survey_question_id = survey_question_id;
        this.survey_id = survey_id.getSurveyId();
        this.type_id = type_id;
        this.question = question;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }

    public Long getSurvey_question_id() {
        return survey_question_id;
    }

    public void setSurvey_question_id(Long survey_question_id) {
        this.survey_question_id = survey_question_id;
    }

    public Long getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(Long survey_id) {
        this.survey_id = survey_id;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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