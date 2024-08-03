package com.gulsahduzgun.todo.business.services.impl;


import com.gulsahduzgun.todo.bean.ModelMapperBean;
import com.gulsahduzgun.todo.business.dto.TaskDto;
import com.gulsahduzgun.todo.data.entity.TaskEntity;
import com.gulsahduzgun.todo.data.repository.ITaskRepository;
import com.gulsahduzgun.todo.exception.GulsahDuzgunException;
import com.gulsahduzgun.todo.exception.NotFound404Exception;
import com.gulsahduzgun.todo.business.services.ITaskServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Log4j2

// SERVICES
@Service
public class TaskServicesImpl implements ITaskServices<TaskDto, TaskEntity> {

    // INJECTION
    private final ITaskRepository iTaskRepository;
    private final ModelMapperBean modelMapperBean;

    // MODEL MAPPER
    @Override
    public TaskDto entityToDto(TaskEntity taskEntity) {
        return modelMapperBean.getModelMapperMethod().map(taskEntity,TaskDto.class);
    }

    @Override
    public TaskEntity dtoToEntity(TaskDto taskDto) {
        return modelMapperBean.getModelMapperMethod().map(taskDto,TaskEntity.class);
    }

    /////////////////////////////////////////////////////////////
    // SPEED DATA
    @Override
    public String taskSpeedData(Integer data) {
        if(data!=null){
            for (int i = 0; i <=data ; i++) {
                TaskEntity taskEntity=new TaskEntity();
                taskEntity.setTaskName("Category Name "+ UUID.randomUUID().toString());
                taskEntity.setTask("Category "+ UUID.randomUUID().toString());
                iTaskRepository.save(taskEntity);
            }
        }else {
            throw new GulsahDuzgunException("Speed Data oluşturulmadı");
        }
        return data+" tane veri eklendi";
    }

    // DELETE ALL
    @Override
    public String taskDeleteAllData() {
        iTaskRepository.deleteAll();
        return taskList()+" tane veri silindi";
    }

    ////////////////////////////////////////////////////////////
    // CRUD
    // @Transaction (Create,Delete,Update)

    // CREATE
    @Override
    @Transactional
    public TaskDto taskCreate(TaskDto taskDto) {
        if(taskDto!=null){
            TaskEntity taskEntity=dtoToEntity(taskDto);
            iTaskRepository.save(taskEntity);
            taskDto.setTaskID(taskEntity.getTaskID());
            taskDto.setTaskName(taskEntity.getTaskName());
            return taskDto;
        }else{
            throw new NullPointerException(TaskDto.class+" boş ");
        }
    }

    // LIST
    @Override
    public List<TaskDto> taskList() {
        Iterable<TaskEntity> taskEntityIterable= iTaskRepository.findAll();
        List<TaskDto> taskDtoList=new ArrayList<>();
        for (TaskEntity entity: taskEntityIterable){
            TaskDto taskDto=entityToDto(entity);
            taskDtoList.add(taskDto);
        }
        log.info(" Category Name Listesi: "+taskDtoList.size());
        //return List.of();
        return taskDtoList;
    }

    // FIND
    @Override
    public TaskDto taskFindById(Long id) {
        TaskEntity findTaskEntity=null;
        if(id!=null){
            findTaskEntity =iTaskRepository.findById(id)
                    .orElseThrow(()->new NotFound404Exception(id+" nolu veri yoktur"));
        }else if(id==null){
            throw new NullPointerException("blog category id null");
        }
        return entityToDto(findTaskEntity);
    }

    // UPDATE
    @Transactional
    @Override
    public TaskDto taskUpdateById(Long id, TaskDto taskDto) {
        TaskDto findTaskDto=taskFindById(id);
        if(findTaskDto!=null){
            TaskEntity taskEntity=dtoToEntity(taskDto);
            taskEntity.setTaskName(taskDto.getTaskName());
            iTaskRepository.save(taskEntity);
            return findTaskDto;
        }
        return null;
    }

    // DELETE
    @Transactional
    @Override
    public TaskDto taskDeleteById(Long taskID) {
        TaskDto findTaskDto=taskFindById(taskID);
        if(findTaskDto!=null){
            iTaskRepository.deleteById(taskID);
            return findTaskDto;
        }
        return null;
    }
}