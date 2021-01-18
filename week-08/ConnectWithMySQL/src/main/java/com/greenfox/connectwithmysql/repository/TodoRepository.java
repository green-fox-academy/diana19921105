package com.greenfox.connectwithmysql.repository;

import com.greenfox.connectwithmysql.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
