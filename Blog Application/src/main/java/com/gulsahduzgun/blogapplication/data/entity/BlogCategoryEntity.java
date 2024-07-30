package com.gulsahduzgun.blogapplication.data.entity;
import com.gulsahduzgun.blogapplication.annotation.AUniqueBlogCategoryName;
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

@Entity(name="BlogCategories")
@Table(name="blogCategories")

// BlogCategoryDto(1)- BlogDto(N)
public class BlogCategoryEntity implements  Serializable{
    public static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="category_id",unique = true,nullable = false, updatable = false, insertable = true)
    private  Long categoryID;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date systemCreateDate;

    @Column(name="category_name")
    private  String categoryName;
}
