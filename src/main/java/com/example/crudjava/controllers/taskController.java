package com.example.crudjava.controllers;

import com.example.crudjava.dao.tareaDao;
import com.example.crudjava.models.tareas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tareas")
public class taskController {

    @Autowired
    private tareaDao taskDao;

    //Obtener las tareas
    @GetMapping
    public List<tareas> getTask(){
        return taskDao.getTareas();
    }

    //Crear tareas
    //RequestBody sirve para deserializar un objeto a partir del cuerpo de la petición
    @PostMapping(consumes = {"*/*"})
    public void registrarTarea(@RequestBody tareas task){
        taskDao.registrarTarea(task);
    }

    //Eliminar tareas
    //@PathVariable sirve para configurar variables dentro de segmentos de la URL
    @DeleteMapping(value = "/{id}")
    public void eliminarTarea(@PathVariable("id") Long id){
        taskDao.eliminarTarea(id);
    }

    //Editar tareas
    @PutMapping
    public void actualizarTarea(@RequestBody tareas task){
        taskDao.actualizarTarea(task);
    }
}
