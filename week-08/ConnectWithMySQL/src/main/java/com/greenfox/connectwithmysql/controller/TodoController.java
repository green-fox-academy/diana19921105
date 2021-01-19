package com.greenfox.connectwithmysql.controller;


import com.greenfox.connectwithmysql.model.Todo;
import com.greenfox.connectwithmysql.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

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

        if (isDone != null) {
            List<Todo> todosInProgress = todos.stream()
                    .filter(t -> !t.isDone())
                    .collect(Collectors.toList());
            model.addAttribute("todos", todosInProgress);
        } else {
            model.addAttribute("todos", todos);
        }

        List<Todo> doneTodos = todos.stream()
                .filter(Todo::isDone)
                .collect(Collectors.toList());

        model.addAttribute("done", doneTodos);
        return "todolist";
    }

    @GetMapping("/add")
    public String add() {
        return "addTodo";
    }

    @PostMapping("/add")
    public String addTodos(@RequestParam String title) {
        todoRepository.save(Todo.builder().title(title).build());
        return "redirect:/todo/";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "redirect:/todo/list";
    }
}
