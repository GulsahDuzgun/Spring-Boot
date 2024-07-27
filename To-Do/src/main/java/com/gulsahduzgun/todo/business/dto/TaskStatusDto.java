package com.gulsahduzgun.todo.business.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder

public class TaskStatusDto implements Serializable {

    public static final Long serialVersionUID = 1L;
    private Long statusID;

    @Builder.Default
    private Date systemCreatedDate = new Date(System.currentTimeMillis());

    @NotEmpty(message = "{task.status.validation.constraints.NotNull.message}")
    @Size(min = 2, message = "{task.status.least.validation.constraints.NotNull.message}")
    private  String statusName;
}
