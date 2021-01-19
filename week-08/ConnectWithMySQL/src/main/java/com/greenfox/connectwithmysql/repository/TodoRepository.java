package com.greenfox.connectwithmysql.repository;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.greenfox.connectwithmysql.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

}
