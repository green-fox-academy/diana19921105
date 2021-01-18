package com.greenfox.connectwithmysql.controller;


import com.greenfox.connectwithmysql.model.Todo;
import com.greenfox.connectwithmysql.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("/todo")
@Controller
public class TodoController {

    private TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping(value = {"/", "/list"})
    public String list(Model model, @RequestParam(required = false) Boolean isDone) {
        List<Todo> todos = (List<Todo>) todoRepository.findAll();
        List<Todo> todos1 = todos.stream()
                .filter(t -> !t.isDone())
                .collect(Collectors.toList());
        if (isDone != null) {
            model.addAttribute("todos", todos1);
        } else {
            model.addAttribute("todos", todoRepository.findAll());
        }

        List<Todo> doneTodos = todos.stream()
                .filter(Todo::isDone)
                .collect(Collectors.toList());

        model.addAttribute("done", doneTodos);
        return "todolist";
    }
}
