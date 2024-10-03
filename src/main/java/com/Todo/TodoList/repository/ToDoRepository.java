package com.Todo.TodoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Todo.TodoList.model.Todo;

//Il repository gestisce l'accesso al database. Usa Spring Data JPA per automatizzare le operazioni CRUD.

public interface ToDoRepository extends JpaRepository<Todo, Long> {

}
