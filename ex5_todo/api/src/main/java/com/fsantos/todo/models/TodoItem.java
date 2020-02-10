package com.fsantos.todo.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class TodoItem {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private boolean done;
}
