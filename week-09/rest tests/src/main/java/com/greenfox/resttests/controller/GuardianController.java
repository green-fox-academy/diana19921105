package com.greenfox.resttests.controller;

import com.greenfox.resttests.model.GrootError;
import com.greenfox.resttests.model.GrootResult;
import com.greenfox.resttests.model.Rocket;
import com.greenfox.resttests.model.RocketError;
import com.greenfox.resttests.model.RocketResult;
import com.greenfox.resttests.model.YonduError;
import com.greenfox.resttests.model.YonduResult;
import com.greenfox.resttests.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GuardianController {

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

    @GetMapping("rocket/fill")
    public ResponseEntity<?> fillRocket(@RequestParam(required = false) String caliber,
                                        @RequestParam(required = false) Integer amount) {
        RocketError error = new RocketError("Task failed succesfully!");

        if (caliber != null && amount != null) {
            return ResponseEntity.ok(new RocketResult(caliber, amount));
        } else {
            return ResponseEntity.badRequest().body(error);
        }
    }
}
