package com.gulsahduzgun.todo.data.entity;

import com.gulsahduzgun.todo.audit.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder

@Entity(name="task")
@Table(name="task")

// BlogCategoryDto(1)- BlogDto(N)
public class TaskEntity extends AuditingAwareBaseEntity implements  Serializable{
    public static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="task_id",unique = true,nullable = false, updatable = false, insertable = true)
    private  Long taskID;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date systemCreateDate;

    @Column(name="status_name")
    private  String statusName;

    @Column(name="task")
    private  String task;

    @Column(name="task_name")
    private  String taskName;
}
