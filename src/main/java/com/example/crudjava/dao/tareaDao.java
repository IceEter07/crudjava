package com.example.crudjava.dao;

import com.example.crudjava.models.tareas;

import java.util.List;

public interface tareaDao {
    List<tareas> getTareas();

    void registrarTarea(tareas task);

}
