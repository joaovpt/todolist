package com.estudos.todolist;

import com.estudos.todolist.entity.Todo;

import java.util.ArrayList;
import java.util.List;

public class TestConstants {
    public static final List<Todo> TODOS = new ArrayList<>() {
        {
            add(new Todo(9995L, "Todo 1", "Todo 1", false, 1));
            add(new Todo(9996L, "Todo 2", "Todo 2", false, 1));
            add(new Todo(9997L, "Todo 3", "Todo 3", false, 1));
            add(new Todo(9998L, "Todo 4", "Todo 4", false, 1));
            add(new Todo(9999L, "Todo 5", "Todo 5", false, 1));
        }
    };

    public static final Todo TODO = TODOS.get(0);
}
