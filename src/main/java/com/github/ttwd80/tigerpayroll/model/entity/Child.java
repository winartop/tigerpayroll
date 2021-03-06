package com.github.ttwd80.tigerpayroll.model.entity;


import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Child generated by hbm2java
 */
@Entity
@Table(name="child"
    ,schema="public"
)
public class Child  implements java.io.Serializable {


     private Integer id;
     private Gender gender;
     private User user;
     private String fullName;
     private String icNo;
     private Date dateOfBirth;
     private Boolean student;
     private Boolean working;
     private Boolean handicapped;
     private String createdBy;
     private ZonedDateTime createdDate;
     private String lastModifiedBy;
     private ZonedDateTime lastModifiedDate;

    public Child() {
    }

	
    public Child(Integer id, Gender gender, User user, String fullName) {
        this.id = id;
        this.gender = gender;
        this.user = user;
        this.fullName = fullName;
    }
    public Child(Integer id, Gender gender, User user, String fullName, String icNo, Date dateOfBirth, Boolean student, Boolean working, Boolean handicapped, String createdBy, ZonedDateTime createdDate, String lastModifiedBy, ZonedDateTime lastModifiedDate) {
       this.id = id;
       this.gender = gender;
       this.user = user;
       this.fullName = fullName;
       this.icNo = icNo;
       this.dateOfBirth = dateOfBirth;
       this.student = student;
       this.working = working;
       this.handicapped = handicapped;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.lastModifiedBy = lastModifiedBy;
       this.lastModifiedDate = lastModifiedDate;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gender_id", nullable=false)
    public Gender getGender() {
        return this.gender;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="username", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="full_name", nullable=false, length=100)
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    
    @Column(name="ic_no", length=20)
    public String getIcNo() {
        return this.icNo;
    }
    
    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_of_birth", length=13)
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    
    @Column(name="student")
    public Boolean getStudent() {
        return this.student;
    }
    
    public void setStudent(Boolean student) {
        this.student = student;
    }

    
    @Column(name="working")
    public Boolean getWorking() {
        return this.working;
    }
    
    public void setWorking(Boolean working) {
        this.working = working;
    }

    
    @Column(name="handicapped")
    public Boolean getHandicapped() {
        return this.handicapped;
    }
    
    public void setHandicapped(Boolean handicapped) {
        this.handicapped = handicapped;
    }

    
    @Column(name="created_by", length=20)
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    
    @Column(name="created_date", length=35)
    @org.springframework.data.annotation.CreatedDate
    public ZonedDateTime getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    
    @Column(name="last_modified_by", length=20)
    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }
    
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    
    @Column(name="last_modified_date", length=35)
    @org.springframework.data.annotation.LastModifiedDate
    public ZonedDateTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }
    
    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }




}


