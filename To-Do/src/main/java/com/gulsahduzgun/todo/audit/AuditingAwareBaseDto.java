package com.gulsahduzgun.todo.audit;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter

abstract public class AuditingAwareBaseDto implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    protected String createdUser;

    protected Date createdDate;

    protected String lastUser;

    protected Date lastDate;
}
