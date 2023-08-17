package com.example.crudjava.dao;

import com.example.crudjava.models.tareas;

import java.util.List;

public interface tareaDao {
    List<tareas> getTareas();


    String registrarTarea(tareas task);

    void eliminarTarea(Long id);

    void actualizarTarea(tareas task);

}
