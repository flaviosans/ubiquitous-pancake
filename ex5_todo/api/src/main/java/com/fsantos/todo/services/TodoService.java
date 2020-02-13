package com.fsantos.todo.services;

import com.fsantos.todo.models.TodoItem;
import com.fsantos.todo.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TodoService {

    private List<TodoItem> todoItems = new ArrayList<>();
    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoService(TodoItemRepository todoItemRepository){
        this.todoItemRepository = todoItemRepository;
    }

    public List<TodoItem> getAll(String query){
        if(!query.equals(""))
            return todoItemRepository.findByDescriptionLikeOrderByCreatedAsc("%"+query+"%");
        else
            return todoItemRepository.findByOrderByCreatedAsc();
    }

    public TodoItem getById(Long id){
        Optional<TodoItem> optionalTodoItem = todoItemRepository.findById(id);
        try{
            return optionalTodoItem.get();
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Todo Item not found"
            );
        }
    }

    public TodoItem save(TodoItem todoItem){
        TodoItem item = TodoItem.builder()
                .description(todoItem.getDescription())
                .build();
        return this.todoItemRepository.save(item);
    }

    public TodoItem update(Long id, TodoItem todoItem){
        TodoItem itemToUpdate = this.getById(id);
        itemToUpdate.setDescription(todoItem.getDescription());
        itemToUpdate.setDone(todoItem.isDone());
        return todoItemRepository.save(itemToUpdate);
    }

    public void delete(Long id){
        TodoItem todoItem = this.getById(id);
        this.todoItemRepository.delete(todoItem);
    }
}
