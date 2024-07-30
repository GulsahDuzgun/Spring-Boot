package com.gulsahduzgun.blogapplication.data.repository;

import com.gulsahduzgun.blogapplication.data.entity.BlogCategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBlogCategoryRepository extends CrudRepository<BlogCategoryEntity, Long> {
  Optional<BlogCategoryEntity>findByCategoryName(String categoryName);
}
