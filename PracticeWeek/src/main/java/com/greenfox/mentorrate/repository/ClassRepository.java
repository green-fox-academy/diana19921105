package com.greenfox.mentorrate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.greenfox.mentorrate.model.Class;

import java.util.Optional;

@Repository
public interface ClassRepository extends CrudRepository<Class, Long> {
    Optional<Class> findByName(String name);
}
