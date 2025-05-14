package com.estudos.todolist.controller;

import com.estudos.todolist.entity.Todo;
import com.estudos.todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<List<Todo>> create(@RequestBody @Valid Todo todo){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(todoService.create(todo));
    }

    @GetMapping
    public List<Todo> list(){
        return todoService.list();
    }

    @PutMapping("{id}")
    public List<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping("{id}")
    public List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }

}
