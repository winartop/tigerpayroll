package com.github.ttwd80.tigerpayroll.model.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * UserRole generated by hbm2java
 */
@Entity
@Table(name="user_role"
    ,schema="public"
    , uniqueConstraints = @UniqueConstraint(columnNames={"username", "role_id"}) 
)
public class UserRole  implements java.io.Serializable {


     private Integer id;
     private Role role;
     private User userByLastModifiedBy;
     private User userByUsername;
     private String createdBy;
     private Date createdDate;
     private Date lastModifiedDate;

    public UserRole() {
    }

	
    public UserRole(Role role, User userByUsername) {
        this.role = role;
        this.userByUsername = userByUsername;
    }
    public UserRole(Role role, User userByLastModifiedBy, User userByUsername, String createdBy, Date createdDate, Date lastModifiedDate) {
       this.role = role;
       this.userByLastModifiedBy = userByLastModifiedBy;
       this.userByUsername = userByUsername;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.lastModifiedDate = lastModifiedDate;
    }
   
     @GenericGenerator(name="generator", strategy="org.hibernate.id.enhanced.SequenceStyleGenerator", parameters={@Parameter(name="optimizer", value="none"), @Parameter(name="sequence_name", value="user_role_id_seq"), @Parameter(name="increment_size", value="1")})@Id @GeneratedValue(generator="generator")

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="role_id", nullable=false)
    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="last_modified_by")
    @org.springframework.data.annotation.LastModifiedBy
    public User getUserByLastModifiedBy() {
        return this.userByLastModifiedBy;
    }
    
    public void setUserByLastModifiedBy(User userByLastModifiedBy) {
        this.userByLastModifiedBy = userByLastModifiedBy;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="username", nullable=false)
    public User getUserByUsername() {
        return this.userByUsername;
    }
    
    public void setUserByUsername(User userByUsername) {
        this.userByUsername = userByUsername;
    }

    
    @Column(name="created_by", length=20)
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date", length=35)
    @org.springframework.data.annotation.CreatedDate
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_modified_date", length=35)
    @org.springframework.data.annotation.LastModifiedDate
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }
    
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }




}


