package com.fsantos.todo.controllers;

import com.fsantos.todo.models.TodoItem;
import com.fsantos.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/todo")
public class TodoItemController {

    private final TodoService todoService;

    @Autowired
    public TodoItemController(TodoService ts){
        this.todoService = ts;
    }

    @GetMapping
    public ResponseEntity<List<TodoItem>> getAll(
            @RequestParam(value = "query", required = false) String query){
        List<TodoItem> todoItems = this.todoService.getAll(query);
        return ResponseEntity.ok(todoItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getById(@PathVariable Long id){
        TodoItem todoItem = this.todoService.getById(id);
        return ResponseEntity.ok(todoItem);
    }

    @PostMapping
    public ResponseEntity<TodoItem> store(@RequestBody TodoItem todoItem){
        todoItem = this.todoService.save(todoItem);
        return ResponseEntity.ok(todoItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> update(
            @PathVariable Long id, @RequestBody TodoItem todoItem){
        todoItem = this.todoService.update(id, todoItem);
        return ResponseEntity.ok(todoItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.todoService.delete(id);
    }
}