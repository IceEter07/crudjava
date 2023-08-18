package com.example.crudjava.controllers;

import com.example.crudjava.dao.tareaDao;
import com.example.crudjava.exception.taskException;
import com.example.crudjava.models.tareas;
import com.example.crudjava.models.taskResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/tareas")
public class taskController {

    @Autowired
    private tareaDao taskDao;

    //Obtener las tareas
    @GetMapping
//    public List<tareas> getTask(){
//        return taskDao.getTareas();
//    }
    public ResponseEntity<?> getTask(){
        return taskDao.getTareas();
    }

    //Crear tareas
    //RequestBody sirve para deserializar un objeto a partir del cuerpo de la petición
    @PostMapping(consumes = {"*/*"})
    public ResponseEntity registrarTarea(@RequestBody tareas task){
        return taskDao.registrarTarea(task);
    }

    //Eliminar tareas
    //@PathVariable sirve para configurar variables dentro de segmentos de la URL
    @DeleteMapping(value = "/{id}")
    public ResponseEntity eliminarTarea(@PathVariable("id") Long id){

        return taskDao.eliminarTarea(id);
    }

    //Editar tareas
    @PutMapping(value = "/{id}")
    public ResponseEntity actualizarTarea(@PathVariable("id") Long id, @RequestBody tareas task){
        return taskDao.actualizarTarea(id, task);
    }
}
