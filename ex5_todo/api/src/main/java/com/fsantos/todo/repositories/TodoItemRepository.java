package com.fsantos.todo.repositories;

import com.fsantos.todo.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    public List<TodoItem> findByOrderByCreatedAsc();
    public List<TodoItem> findByDescriptionLikeOrderByCreatedAsc(String description);

}
