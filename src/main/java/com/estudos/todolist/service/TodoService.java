package com.estudos.todolist.service;

import com.estudos.todolist.entity.Todo;
import com.estudos.todolist.repository.TodoRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Long id, Todo todo){
        todoRepository.findById(id).ifPresentOrElse((existingTodo) -> {
            todo.setId(id);
            todoRepository.save(todo);
        }, () -> {
            try {
                throw new BadRequestException("Todo %d não existe! ".formatted(id));
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        });

        return list();
    }

    public List<Todo> delete(Long id){
        todoRepository.findById(id).ifPresentOrElse((existingTodo) -> todoRepository.delete(existingTodo), () -> {
            try {
                throw new BadRequestException("Todo %d não existe! ".formatted(id));
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        });
        return list();
    }




}
