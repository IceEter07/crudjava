package com.example.crudjava.dao;

import com.example.crudjava.models.tareas;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface tareaDao {
    List<tareas> getTareas();

    ResponseEntity registrarTarea(tareas task);

    void eliminarTarea(Long id);

    void actualizarTarea(tareas task);

}
