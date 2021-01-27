package com.greenfox.backend_api.repository;

import com.greenfox.backend_api.model.Log;
import org.springframework.data.repository.CrudRepository;

public interface RestRepository extends CrudRepository<Log, Long> {
}
