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
            TaskEntity taskEntity1=TaskEntity.builder().task("Task Header").taskName("Task Detail").statusName("Done").build();
            iTaskRepository.save(taskEntity1);

            TaskEntity taskEntity2=TaskEntity.builder().task("Redux.js").taskName("Learn Redux.js").statusName("Not Started").build();
            iTaskRepository.save(taskEntity2);

            TaskEntity taskEntity3=TaskEntity.builder().task("React.js").taskName("Make projects with React.js").statusName("In Progress").build();
            iTaskRepository.save(taskEntity3);

            TaskEntity taskEntity4=TaskEntity.builder().task("Java").taskName("Read more article about Java").statusName("In Progress").build();
            iTaskRepository.save(taskEntity4);
        };
    }
    // START
    public void end(){
        log.info("###END#######");
    }
}