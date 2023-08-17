package com.example.crudjava.dao;

import com.example.crudjava.models.tareas;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface tareaDao {
    List<tareas> getTareas();
    //ResponseEntity<List<tareas>> getTareas();


    void registrarTarea(tareas task);

    void eliminarTarea(Long id);

    void actualizarTarea(tareas task);

}
