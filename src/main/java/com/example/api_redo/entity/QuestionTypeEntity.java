package com.example.api_redo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name="question_types ")
public class QuestionTypeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="type_id")
    private Long type_id;

    @Column(name="type_name")
    private String type_name;

    @Column(name="date_created")
    private Date date_created;

    @Column(name="date_modified")
    private Date date_modified;

    public QuestionTypeEntity() {
    }

    public QuestionTypeEntity(Long type_id, String type_name, Date date_created, Date date_modified) {
        this.type_id = type_id;
        this.type_name = type_name;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
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
