package com.example.api_redo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="roles")
public class RoleEntity {

    @Id
    @Column(name="role_name")
    private String roleName;

    @Column(name="date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name="date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    public RoleEntity(){

    }

    public RoleEntity(String roleName, Date dateCreated, Date dateModified){
        this.roleName = roleName;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    @PrePersist
    protected void onCreate() {
        dateCreated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        dateModified = new Date();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getDateCreated(){
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated){
        this.dateCreated = dateCreated;
    }

    public Date getDateModified(){
        return dateModified;
    }

    public void setDateModified(Date dateModified){
        this.dateModified = dateModified;
    }
}
