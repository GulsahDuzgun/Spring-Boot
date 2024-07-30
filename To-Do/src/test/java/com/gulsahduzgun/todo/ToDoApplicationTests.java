package com.gulsahduzgun.todo;
import com.gulsahduzgun.todo.data.entity.TaskEntity;
import com.gulsahduzgun.todo.data.repository.ITaskRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// IMPORT
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
// LOMBOK
@Log4j2

@SpringBootTest
class ToDoApplicationTests implements ITestCRUD {

    // INJECTION
    private final ITaskRepository iTaskRepository;

    @Autowired
    public ToDoApplicationTests(ITaskRepository iTaskRepository) {
        this.iTaskRepository = iTaskRepository;
    }

    @BeforeAll
    static void getBeforeTasks() {
        System.out.println("BeforeAll comes before all of these methods");
        log.info("BeforeAll comes before all of these methods");
    }

    @BeforeEach
    void getBeforeEachTasks() {
        System.out.println("BeforeEach comes before running test methods");
        log.info("BeforeEach comes before running test methods");
    }

    // CREATE
    @Override
    @Test
    public void testCreateDatabase() {
        System.out.println("Test Create Task Database");
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskName("test_blog_category");
        taskEntity.setTask("Test 1");

        iTaskRepository.save(taskEntity);
        assertNotNull(iTaskRepository.findById(1L).get());
        // Eğer bulamazsa => java.util.NoSuchElementException: No value present
    }

    // FIND
    @Override
    @Test
    public void testFindDatabase() {
        System.out.println("Test Find");
        TaskEntity taskEntity = iTaskRepository.findById(1L).get();
        assertEquals("task-1", taskEntity.getTaskName());
    }

    // LIST
    @Override
    @Test
    public void testListDatabase() {
        System.out.println("Test List ");
        Iterable<TaskEntity> taskEntityList = iTaskRepository.findAll();
        assertThat(taskEntityList).size().isGreaterThan(0);
    }

    // UPDATE
    @Override
    @Test
    public void testUpdateDatabase() {
        System.out.println("Test Update");
        TaskEntity taskEntity = iTaskRepository.findById(1L).get();
        taskEntity.setTaskName("next situation is");
        taskEntity.setTask("React");
        iTaskRepository.save(taskEntity);
        // Önceki ile şimdi eklediğim eşit olmamalı
        assertNotEquals("computer", iTaskRepository.findById(1L).get().getTaskName());
    }

    /*
    @Override
    @Test
    public void testDeleteDatabase() {
        System.out.println("Test Delete ");
        iTaskRepository.deleteById(1L);
        //assertThat(iTaskRepository.findById(1L).isPresent()).isFalse();
        assertThat(iTaskRepository.existsById(1L)).isFalse();
    }
    */
    @Test
    public void getFail(){
        Assertions.fail("Hata gönderildi");
    }

    @AfterEach
    void getAfterEachTasks() {
        System.out.println("AfterEach comes after all of these methods  ");
        log.info("AfterEach comes after all of these methods ");
    }

    @AfterAll
    static void getAfterAllTasks() {
        System.out.println("AfterAll comes after all methods have run");
        log.info("AfterAll comes after all methods have run");
    }
}
