package com.gulsahduzgun.todo.data.repository;


import com.gulsahduzgun.todo.data.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITaskRepository extends CrudRepository<TaskEntity, Long> {
  Optional<TaskEntity>findByStatusName(String statusName);
  Optional<TaskEntity>findByTaskName(String taskName);

}

