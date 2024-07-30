package com.gulsahduzgun.todo.data.repository;


import com.gulsahduzgun.todo.data.entity.TaskStatusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITaskStatusRepository extends CrudRepository<TaskStatusEntity, Long> {
  Optional<TaskStatusEntity>findByStatusName(String statusName);
}
