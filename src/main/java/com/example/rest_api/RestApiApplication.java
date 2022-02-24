package com.example.rest_api;

import com.example.rest_api.entity.Rolles;
import com.example.rest_api.entity.User;
import com.example.rest_api.entity.Todo;
import com.example.rest_api.repository.RollesRepository;
import com.example.rest_api.repository.TodoRepository;
import com.example.rest_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.time.Duration;


@SpringBootApplication
@EnableSwagger2
public class RestApiApplication implements CommandLineRunner {

    @Autowired
   private UserRepository userRepository;
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private RollesRepository rollesRepository;


    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setUsername("Bob");
        user.setPassword("should be hashed");
        user.setEmail("@");

        Todo todo = new Todo();
        todo.setName("gotoGym");
        todo.setOwner("Bob");

        todo.setTimeofcreate(Duration.ZERO);
        todo.setStatus(false);

        Rolles rolles = new Rolles();
        rolles.setId(1l);
        rolles.setUser(user);
        rolles.setRole(rolles.getRole());




        user.getTodoList().add(todo);

        todoRepository.save(todo);
        userRepository.save(user);
        rollesRepository.save(rolles);
    }
}
