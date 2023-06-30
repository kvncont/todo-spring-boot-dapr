package com.github.kvncont.todospringbootdapr;

import java.util.Optional;

public interface TodoRepository {

    Todo saveTodo(final Todo todo);

    Optional<Todo> getTodoById(final int id);

    Optional<Todo> getAllTodo();
}
