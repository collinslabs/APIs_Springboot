package com.example.api_redo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name ="surveys")
public class SurveyEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="survey_id")
    private Long SurveyId;
    //FOREIGN KEY
    @Column(name="user_id")
    private Long userId;

    @Column(name="survey_name")
    private String survey_name;

    @Column(name="description")
    private String description;

    @Column(name="date_created")
    private Date date_created;

    @Column(name="date_modified")
    private Date date_modified;

    public SurveyEntity() {
    }

    public SurveyEntity(Long surveyId, UserEntity userId, String survey_name, String description, Date date_created, Date date_modified) {
        SurveyId = surveyId;
        this.userId = userId.getUserId();
        this.survey_name = survey_name;
        this.description = description;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }


    public Long getSurveyId() {
        return SurveyId;
    }

    public void setSurveyId(Long surveyId) {
        SurveyId = surveyId;
    }

    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSurvey_name() {
        return survey_name;
    }

    public void setSurvey_name(String survey_name) {
        this.survey_name = survey_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
