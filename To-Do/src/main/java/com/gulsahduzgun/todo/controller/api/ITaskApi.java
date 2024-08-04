package com.gulsahduzgun.todo.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITaskApi<D> {

    public ResponseEntity<String> taskAllDelete();

    public ResponseEntity<?> taskCreate(D d);

    public ResponseEntity<List<D>>  taskList();

    public ResponseEntity<?>  taskUpdateById(Long id,D d);

    public ResponseEntity<?> taskDeleteById(Long id);

}