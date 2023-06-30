package com.github.kvncont.todospringbootdapr;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(final TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping("/state")
    public ResponseEntity<Void> saveState(@RequestBody final Todo todo) {
        var state = new Todo(todo.id(), todo.description());
        todoRepository.saveTodo(state);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/state/{id}")
    public ResponseEntity<Optional<Todo>> getState(@PathVariable int id) {
        // var response = todoRepository.getTodoById(id);
        return ResponseEntity.ok(todoRepository.getTodoById(id));
    }
}
