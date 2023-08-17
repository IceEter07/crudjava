package com.example.crudjava.controllers;

import com.example.crudjava.models.tareas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tareas")
public class taskController {

    @GetMapping
    public tareas getTask(){
        tareas task = new tareas();
        task.setId(1L);
        task.setDescripcion("Hlalallalasf");
        task.setEstatus("NASHDSADF");
        return task;
    }
}
