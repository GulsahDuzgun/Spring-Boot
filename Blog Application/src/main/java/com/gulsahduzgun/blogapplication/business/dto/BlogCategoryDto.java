package com.gulsahduzgun.blogapplication.business.dto;

import com.gulsahduzgun.blogapplication.annotation.AUniqueBlogCategoryName;
import com.gulsahduzgun.blogapplication.audit.AuditingAwareBaseEntity;
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

public class BlogCategoryDto extends AuditingAwareBaseEntity implements Serializable {

    public static final Long serialVersionUID = 1L;
    private Long categoryID;

    @Builder.Default
    private Date systemCreatedDate = new Date(System.currentTimeMillis());

    @NotEmpty(message = "{blog.category.validation.constraints.NotNull.message}")
    @Size(min = 2, message = "{blog.category.least.validation.constraints.NotNull.message}")
    @AUniqueBlogCategoryName
    private  String categoryName;
}
