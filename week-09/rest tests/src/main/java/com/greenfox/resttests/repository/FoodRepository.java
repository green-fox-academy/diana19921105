package com.greenfox.resttests.repository;

import com.greenfox.resttests.model.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {
}
