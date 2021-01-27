package com.greenfox.backend_api.controller;

import com.greenfox.backend_api.model.Append;
import com.greenfox.backend_api.model.Arrays;
import com.greenfox.backend_api.model.ArraysError;
import com.greenfox.backend_api.model.Doubling;
import com.greenfox.backend_api.model.ErrorMessage;
import com.greenfox.backend_api.model.Greeting;
import com.greenfox.backend_api.model.Log;
import com.greenfox.backend_api.model.LogResult;
import com.greenfox.backend_api.model.MissingName;
import com.greenfox.backend_api.model.MissingNameAndTitle;
import com.greenfox.backend_api.model.MissingTitle;
import com.greenfox.backend_api.model.Result;
import com.greenfox.backend_api.model.ResultArray;
import com.greenfox.backend_api.model.ResultSingle;
import com.greenfox.backend_api.model.Sith;
import com.greenfox.backend_api.model.SithResult;
import com.greenfox.backend_api.model.Until;
import com.greenfox.backend_api.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class MainRestController {
    private MainService mainService;

    @Autowired
    public MainRestController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/doubling")
    public ResponseEntity<?> doubling(@RequestParam(required = false) Integer input) {
        mainService.save(Log.builder().endPoint("/doubling").data("input = " + input).createdAt(new Timestamp(System.currentTimeMillis())).build());

        if (input != null) {
            return ResponseEntity.ok(new Doubling(input));
        } else {
            return ResponseEntity.ok(new ErrorMessage());
        }
    }

    @GetMapping("/greeter")
    public ResponseEntity<?> getGreeting(@RequestParam(required = false) String name,
                                         @RequestParam(required = false) String title) {
        mainService.save(Log.builder().endPoint("/greeter").data("name =" + name + ", title =" + title).createdAt(new Timestamp(System.currentTimeMillis())).build());
        if (name == null || title == null) {
            if (name != null) {
                return ResponseEntity.badRequest().body(new MissingTitle());
            }
            if (title != null) {
                return ResponseEntity.badRequest().body(new MissingName());
            } else {
                return ResponseEntity.badRequest().body(new MissingNameAndTitle());
            }
        } else {
            return ResponseEntity.ok(new Greeting("Oh, hi there " + name + ", my dear " + title + "!"));
        }
    }

    @GetMapping("/appenda/{appendable}")
    public ResponseEntity<?> appendA(@PathVariable String appendable) {
        mainService.save(Log.builder().endPoint("/appenda/{appendable}").data("appendable =" + appendable).createdAt(new Timestamp(System.currentTimeMillis())).build());
        if (appendable == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(new Append(appendable));
        }
    }

    @PostMapping("/dountil/{action}")
    public ResponseEntity<?> doUntil(@PathVariable String action,
                                     @RequestBody Until until) {
        mainService.save(Log.builder().endPoint("/dountil/{action}").data("action, until =" + until).createdAt(new Timestamp(System.currentTimeMillis())).build());
        if (action.equals("sum") || action.equals("factor")) {
            return ResponseEntity.ok(new Result(action, until.getUntil()));
        } else {
            return ResponseEntity.ok(new ErrorMessage());
        }
    }

    @PostMapping("/arrays")
    public ResponseEntity<?> arrays(@RequestBody Arrays arrays) {
        mainService.save(Log.builder().endPoint("/arrays").data("arrays= " + arrays).createdAt(new Timestamp(System.currentTimeMillis())).build());
        if (arrays.getWhat().equals("sum")) {
            int sum = 0;
            for (int i = 0; i < arrays.getNumbers().size(); i++) {
                sum += arrays.getNumbers().get(i);
            }
            return ResponseEntity.ok(ResultSingle.builder().result(sum).build());

        }
        if (arrays.getWhat().equals("multiply")) {
            int multiply = 1;
            for (int i = 0; i < arrays.getNumbers().size(); i++) {
                multiply *= arrays.getNumbers().get(i);
            }
            return ResponseEntity.ok(ResultSingle.builder().result(multiply).build());

        }
        if (arrays.getWhat().equals("double")) {
            return ResponseEntity.ok(new ResultArray(arrays.getNumbers()));
        }
        return ResponseEntity.ok(new ArraysError());
    }

    @GetMapping("log")
    public ResponseEntity<?> getLogs() {
        LogResult logResult = mainService.getLogs();
        if (logResult == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(logResult);
        }
    }

    @PostMapping("/sith")
    public ResponseEntity<?> sithText(@RequestBody Sith sithInput) {
        if (sithInput == null) {
            return ResponseEntity.badRequest().build();
        } else {
            Sith sithOutput = new Sith(sithInput.getText());
            String reversedSith = sithOutput.getText();
            return ResponseEntity.ok(new SithResult(reversedSith));
        }
    }
}
