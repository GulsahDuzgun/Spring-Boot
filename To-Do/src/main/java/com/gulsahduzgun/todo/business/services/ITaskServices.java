package com.gulsahduzgun.todo.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface ITaskServices<D,E> {

    // MODEL MAPPER
    public D entityToDto(E e);
    public E dtoToEntity(D d);


    // CRUD
    // CREATE
    public D taskCreate(D d);

    // LIST
    public List<D> taskList();

  // public List<D> taskStatusList();

    // FIND
    public D taskFindById(Long id);

    // UPDATE
    public D taskUpdateById(Long id,D d);

    // DELETE
    public D taskDeleteById(Long taskID);

    // SPEED DATA
    public String taskSpeedData(Integer data);

    // DELETE ALL
    public String taskDeleteAllData();
} //end interface
