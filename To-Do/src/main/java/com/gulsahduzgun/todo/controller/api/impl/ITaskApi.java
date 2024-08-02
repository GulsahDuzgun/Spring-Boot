package com.gulsahduzgun.todo.controller.api.impl;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITaskApi<D> {

    public ResponseEntity<String> taskAllDelete();

    public ResponseEntity<?> taskCreate(D d);

    public ResponseEntity<List<D>>  taskList();

    public ResponseEntity<?>  taskUpdate(Long id,D d);

    public ResponseEntity<?> taskDeleteById(Long id);

}