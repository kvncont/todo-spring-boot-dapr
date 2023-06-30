package com.github.kvncont.todospringbootdapr;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import io.dapr.client.DaprClient;
import reactor.core.publisher.Mono;

@Repository
public class DaprTodoRepository implements TodoRepository {

    private static final String DAPR_STORE_NAME = "statestore";

    private final DaprClient daprClient;

    public DaprTodoRepository(final DaprClient daprClient) {
        this.daprClient = daprClient;
    }

    @Override
    public Todo saveTodo(Todo todo) {
        daprClient.saveState(DAPR_STORE_NAME, String.valueOf(todo.id()), todo).block();
        Mono<io.dapr.client.domain.State<Todo>> result = daprClient.getState(DAPR_STORE_NAME, String.valueOf(todo.id()),
                Todo.class);
        return result.block().getValue();
    }

    @Override
    public Optional<Todo> getTodoById(int id) {
        Mono<io.dapr.client.domain.State<Todo>> result = daprClient.getState(DAPR_STORE_NAME, String.valueOf(id),
                Todo.class);
        return Optional.ofNullable(result.block().getValue());
    }

    @Override
    public Optional<Todo> getAllTodo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllTodo'");
    }

}
