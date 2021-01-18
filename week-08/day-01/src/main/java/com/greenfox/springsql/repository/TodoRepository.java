package com.greenfox.springsql.repository;

import com.greenfox.springsql.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
