package com.gulsahduzgun.blogapplication.data.repository;

import com.gulsahduzgun.blogapplication.data.entity.BlogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// CrudRepository<BlogCategoryEntity,Long>
// JpaRepository<BlogCategoryEntity,Long>
// PagingAndSortingRepository<BlogCategoryEntity,Long>

@Repository
public interface IBlogRepository extends CrudRepository<BlogEntity,Long> {

}