package com.Todo.TodoList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Todo.TodoList.model.Todo;
import com.Todo.TodoList.repository.ToDoRepository;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<Todo> getAllTodos() {
        return toDoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return toDoRepository.findById(id);
    }

    public Todo createToDO(Todo todo) {
        return toDoRepository.save(todo);
    }

    public void deliteTodo(Todo todo) {
        toDoRepository.delete(todo);
    }

    public Todo updateToDo(Long id, Todo unpdateTodo) {
        return toDoRepository.findById(id) // Questa riga cerca l'entità Todo nel database
                .map(todo -> {// viene utilizzato per operare sul contenuto dell'Optional, se presente. in
                              // caso lo fosse viene passata alla funzione lambda(->)
                    todo.setTitle(unpdateTodo.getTitle());
                    todo.setCompleted(unpdateTodo.isCompleted());
                    return toDoRepository.save(todo);
                }).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

}
