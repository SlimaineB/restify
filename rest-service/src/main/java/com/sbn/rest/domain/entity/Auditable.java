package com.sbn.rest.domain.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.util.Date;

import com.sbn.rest.domain.listener.AuditEntityListener;

import lombok.Getter;
import lombok.Setter;

import static javax.persistence.TemporalType.TIMESTAMP;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditEntityListener.class)
public abstract class Auditable<U> {
  
	/*@CreatedBy
    protected U createdBy;
    
    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date creationDate;
    
    @LastModifiedBy
    protected U lastModifiedBy;
    
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date lastModifiedDate;*/
}
