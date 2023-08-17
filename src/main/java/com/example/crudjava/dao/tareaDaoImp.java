package com.example.crudjava.dao;

import com.example.crudjava.models.tareas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Encargado de realizar los cambios de los datos del microservicio
@Repository
@Transactional
public class tareaDaoImp implements tareaDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<tareas> getTareas() {
        String query = "From tareas";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrarTarea(tareas task) {
        entityManager.persist(task);
    }
}
