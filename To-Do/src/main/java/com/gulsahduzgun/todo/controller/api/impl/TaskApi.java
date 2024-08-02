package com.gulsahduzgun.todo.controller.api.impl;

import com.gulsahduzgun.todo.business.dto.TaskDto;
import com.gulsahduzgun.todo.business.services.ITaskServices;
import com.gulsahduzgun.todo.utils.frontend.ReactFrontend;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// API
@RestController
@CrossOrigin(origins = ReactFrontend.REACT_FRONTEND_PORT_URL) // http://localhost:3000
@RequestMapping("/task/api/v1")
public class TaskApi implements ITaskApi<TaskDto> {

    // Injection
    private final ITaskServices iTaskServices;


    // ALL DELETE
    // http://localhost:4444/blog/category/api/v1/delete/all
    @Override
    @DeleteMapping(value="/delete/all")
    public ResponseEntity<String> taskAllDelete() {
        return ResponseEntity.ok(iTaskServices.taskDeleteAllData());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CREATE
    // http://localhost:4444/blog/category/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> taskCreate(@Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(iTaskServices.taskCreate(taskDto));
    }

    // LIST
    // http://localhost:4444/blog/category/api/v1/list
    @Override
    @GetMapping(value="/list")
    public ResponseEntity<List<TaskDto>> taskList() {
        return ResponseEntity.status(HttpStatus.OK).body(iTaskServices.taskList());
    }

    // UPDATE
    // http://localhost:4444/blog/category/api/v1/update/1
    @Override
    @PutMapping(value="/update/{id}")
    public ResponseEntity<?> taskUpdate(@PathVariable(name = "id") Long id, @Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok().body(iTaskServices.taskUpdateById(id,taskDto));
    }

    // DELETE BY ID
    // http://localhost:4444/blog/category/api/v1/delete/1
    @Override
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> taskDeleteById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(iTaskServices.taskDeleteById(id),HttpStatus.OK);
    }

}