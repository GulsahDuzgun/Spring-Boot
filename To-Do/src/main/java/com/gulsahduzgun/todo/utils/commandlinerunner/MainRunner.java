package com.gulsahduzgun.todo.utils.commandlinerunner;
import com.gulsahduzgun.todo.data.entity.TaskEntity;
import com.gulsahduzgun.todo.data.repository.ITaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// LOMBOK
@RequiredArgsConstructor

// Command Line runner
@Configuration
@Log4j2
public class MainRunner {

    // INJECTION
    private final ITaskRepository iTaskRepository;

    // START
    public void start(){
        log.info("###START#######");
    }
    // Command Line Runner
    @Bean
    public CommandLineRunner blog(){
        // Lambda Expression
        return args -> {
            log.info("Blog Categories");
            System.out.println("Blog Categories");
            TaskEntity taskEntity1=TaskEntity.builder().task("week-1").taskName("task-1").build();
            iTaskRepository.save(taskEntity1);

            TaskEntity taskEntity2=TaskEntity.builder().task("week-2").taskName("task-2").build();
            iTaskRepository.save(taskEntity2);

            TaskEntity taskEntity3=TaskEntity.builder().task("week-3").taskName("task-3").build();
            iTaskRepository.save(taskEntity3);
        };
    }
    // START
    public void end(){
        log.info("###END#######");
    }
}