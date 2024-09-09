package com.example.api_redo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name ="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email")
    private String email;

    @Column(name="date_of_birth")
    private Date date_of_birth;

    // FOREIGN KEY
    @Column(name="role_name")
    private String roleName;

    @Column(name="password")
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_created")
    private Date date_created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_modified")
    private Date date_modified;


    @PrePersist
    protected void onCreate() {
        this.date_created = new Date();
        this.date_modified = new Date();
    }


    @PreUpdate
    protected void onUpdate() {
        this.date_modified = new Date();
    }

    public UserEntity() {
    }

    public UserEntity(Long userId, String first_name, String last_name, String email, Date date_of_birth, RoleEntity roleName, String password) {
        this.userId = userId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.roleName = roleName.getRoleName();
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
