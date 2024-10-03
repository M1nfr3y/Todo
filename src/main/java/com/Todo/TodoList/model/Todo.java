package com.Todo.TodoList.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity//utilizzata nel contesto di Spring Data JPA Un'entità rappresenta una tabella nel database
@Data //fa parte di una libreria di lombock che genera automaticamente getter, setter, equals, hashCode, e toString
public class Todo {
    
    @Id//chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String title;
    private boolean completed;
}
