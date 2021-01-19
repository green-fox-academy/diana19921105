package com.greenfox.connectwithmysql.repository;

import com.greenfox.connectwithmysql.model.Assignee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
    Optional<Assignee> findByName(String mari);
}
