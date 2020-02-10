package com.fsantos.todo.services;

import com.fsantos.todo.models.TodoItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private List<TodoItem> todoItems = new ArrayList<>();

    public TodoService(){
        for(Long i = 1L; i < 10L; i++){
            todoItems.add(TodoItem.builder()
                    .id(i)
                    .description("Sample")
                    .done(false).build()
            );
        }
    }

    public List<TodoItem> getAll(){
        return todoItems;
    }

    public TodoItem getById(Long id){
        return this.todoItems.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .get();
    }

    public TodoItem save(TodoItem todoItem){
        TodoItem item = TodoItem.builder()
                .description(todoItem.getDescription())
                .id((long) todoItems.size() + 1)
                .build();
        todoItems.add(item);
        return item;
    }

    public TodoItem update(Long id, TodoItem todoItem){
        TodoItem itemToUpdate = this.getById(id);
        itemToUpdate.setDescription(todoItem.getDescription());
        return itemToUpdate;
    }

    public void delete(Long id){
        TodoItem toDelete = this.getById(id);
        todoItems.remove(toDelete);
    }
}
