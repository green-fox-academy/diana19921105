package com.greenfox.resttests.service;

import com.greenfox.resttests.model.Food;
import com.greenfox.resttests.repository.GuardianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GuardianService {

    private GuardianRepository guardianRepository;

    @Autowired
    public GuardianService(GuardianRepository guardianRepository) {
        this.guardianRepository = guardianRepository;
    }

    public ResponseEntity<?> findAllFoods() {
        return ResponseEntity.ok(guardianRepository.findAll());
    }

    public ResponseEntity<?> addFood(Food food) {
        return ResponseEntity.ok(guardianRepository.save(food));
    }

    public ResponseEntity<?> deleteFood(Long id) {
        guardianRepository.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
