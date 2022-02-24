package com.example.rest_api.controller;

import com.example.rest_api.entity.Todo;
import com.example.rest_api.entity.User;
import com.example.rest_api.enumRoles.Rolles;
import com.example.rest_api.repository.TodoRepository;
import com.example.rest_api.repository.UserRepository;
import com.example.rest_api.requist.AddUserRequist;
import com.example.rest_api.requist.AddtodoRequist;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private TodoRepository todoRepository;

    public UserController(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    @RequestMapping("/{userId}")
    public User getUserbyId(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());

    }
    @PostMapping
    public User addUser(@RequestBody AddUserRequist userRequist){
        User user = new User();
        user.setUsername(userRequist.getName());
        user.setPassword(userRequist.getPassword());
        user.setEmail(userRequist.getEmail());
        return userRepository.save(user);
    }
    @PostMapping("/{userId}/todos")
    public void addTodo(@PathVariable Long userId,@RequestBody AddtodoRequist todoRequest){
        User user = userRepository.findById(userId).orElseThrow(()-> new NoSuchElementException());
        Todo todo = new Todo();
        todo.setName(todoRequest.getName());
        todo.setOwner(todoRequest.getOwner());
        todo.setStatus(todoRequest.getStatus());
        todo.setTimeofcreate(todo.getTimeofcreate());
        todoRepository.save(todo);
        userRepository.save(user);
        user.getTodoList().add(todo);
    }

    @PostMapping("/todos/{todoId}")
    public  void todoStatus(@PathVariable Long todoId){
        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NoSuchElementException());
        todo.setStatus(todo.setStatus(true));
        todoRepository.save(todo);
     }
     @DeleteMapping("todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId){
        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NoSuchElementException());
        todoRepository.delete(todo);
      /*   private boolean canRemoveTodo(User user) {
             boolean canRemove;
             try {
                 User currentUser = getUserbyId(1l);
                 if (currentUser.getId()equals(currentUser.getId()) || currentUser.getRolles().contains(Rolles.ROLE_ADMIN)){
                     canRemove = true;
                 } else {
                     canRemove = false;
                 }
             } catch (Exception e) {
                 canRemove = false;
             }

             return canRemove;
         }*/
    }

    @DeleteMapping("users/{userId}")
    public void deledeUser(@PathVariable Long userId){
        User user = userRepository.findById(userId).orElseThrow(()-> new NoSuchElementException());
        userRepository.delete(user);
    }
}
