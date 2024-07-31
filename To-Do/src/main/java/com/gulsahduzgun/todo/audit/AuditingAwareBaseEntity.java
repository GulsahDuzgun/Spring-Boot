package com.gulsahduzgun.todo.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter

// Entity Super Class
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"created_date","last_date"},allowGetters = true)
abstract public class AuditingAwareBaseEntity  implements Serializable {


    public static final Long serialVersionUID=1L;


    @CreatedBy
    @Column(name="created_user")
    protected String createdUser;

    @CreatedDate
    @Column(name="created_date")
    protected Date createdDate;


    @LastModifiedBy
    @Column(name="last_user")
    protected String lastUser;


    @LastModifiedDate
    @Column(name="last_date")
    protected Date lastDate;
}