package com.Todo.TodoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Todo.TodoList.model.Todo;
import com.Todo.TodoList.service.ToDoService;

@RestController // le risposte vengono serializzate automaticamente in JSON (o altri formati
                // come XML)
@RequestMapping("api/todos") // viene utilizzata per mappare le richieste HTTP È una delle annotazioni
                             // centrali di Spring MVC e Spring Web
public class TodoController {

    @Autowired
    ToDoService toDoService;

    @GetMapping
    public List<Todo> findAll() {
        return toDoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        return toDoService.getTodoById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
