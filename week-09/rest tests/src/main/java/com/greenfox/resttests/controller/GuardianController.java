package com.greenfox.resttests.controller;

import com.greenfox.resttests.model.Food;
import com.greenfox.resttests.model.GrootError;
import com.greenfox.resttests.model.GrootResult;
import com.greenfox.resttests.model.Rocket;
import com.greenfox.resttests.model.RocketError;
import com.greenfox.resttests.model.RocketResult;
import com.greenfox.resttests.model.YonduError;
import com.greenfox.resttests.model.YonduResult;
import com.greenfox.resttests.service.GuardianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GuardianController {

//    private GuardianService guardianService;
//
//    public GuardianController(GuardianService guardianService) {
//        this.guardianService = guardianService;
//    }

    @GetMapping("/groot")
    public ResponseEntity<?> groot(@RequestParam(required = false) String message) {
        GrootError error = new GrootError("I am Groot!");

        if (message != null) {
            return ResponseEntity.ok(new GrootResult(message));
        } else {
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/yondu")
    public ResponseEntity<?> yondu(@RequestParam(required = false) Double distance,
                                   @RequestParam(required = false) Double time) {
        YonduError error = new YonduError("Something went wrong!");

        if (distance != null && time != null) {
            return ResponseEntity.ok(new YonduResult(distance, time));
        } else {
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/rocket")
    public ResponseEntity<?> rocket() {
        Rocket rocket = new Rocket();
        return ResponseEntity.ok(rocket);
    }

    @GetMapping("/rocket/fill")
    public ResponseEntity<?> fillRocket(@RequestParam(required = false) String caliber,
                                        @RequestParam(required = false) Integer amount) {
        RocketError error = new RocketError("Task failed successfully!");

        if (caliber != null && amount != null) {
            return ResponseEntity.ok(new RocketResult(caliber, amount));
        } else {
            return ResponseEntity.badRequest().body(error);
        }
    }

//    @GetMapping("/drax")
//    public ResponseEntity<?> getAllFood() {
//        return ResponseEntity.ok(guardianService.findAllFoods());
//    }

//    @PostMapping("/drax")
//    public ResponseEntity<?> addFood(@RequestBody(required = false) Food food) {
//        if (food != null) {
//            return new ResponseEntity<>(guardianService.addFood(food), HttpStatus.CREATED);
//        } else {
//            return ResponseEntity.noContent().build();
//        }
//    }
//
//    @DeleteMapping("/drax")
//    public ResponseEntity<?> deleteFood(@RequestBody(required = false) Long id) {
//        if (id != null) {
//
//            return new ResponseEntity<>(guardianService.deleteFood(id), HttpStatus.ACCEPTED);
//        } else {
//            return ResponseEntity.noContent().build();
//        }
//    }
//    @RequestMapping(value = "/drax/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<?> updateFood(@PathVariable Long id) {
//        if (id != null) {
//        }
//    }
}
