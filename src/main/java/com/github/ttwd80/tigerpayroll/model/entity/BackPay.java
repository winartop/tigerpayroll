package com.github.ttwd80.tigerpayroll.model.entity;


import java.math.BigDecimal;
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
 * BackPay generated by hbm2java
 */
@Entity
@Table(name="back_pay"
    ,schema="public"
)
public class BackPay  implements java.io.Serializable {


     private Integer id;
     private BackPayType backPayType;
     private User user;
     private BigDecimal amount;
     private Date date;
     private String createdBy;
     private ZonedDateTime createdDate;

    public BackPay() {
    }

	
    public BackPay(Integer id, User user, BigDecimal amount, Date date) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.date = date;
    }
    public BackPay(Integer id, BackPayType backPayType, User user, BigDecimal amount, Date date, String createdBy, ZonedDateTime createdDate) {
       this.id = id;
       this.backPayType = backPayType;
       this.user = user;
       this.amount = amount;
       this.date = date;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
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
    @JoinColumn(name="back_pay_type")
    public BackPayType getBackPayType() {
        return this.backPayType;
    }
    
    public void setBackPayType(BackPayType backPayType) {
        this.backPayType = backPayType;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="username", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="amount", nullable=false, precision=16)
    public BigDecimal getAmount() {
        return this.amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date", nullable=false, length=13)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
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




}


