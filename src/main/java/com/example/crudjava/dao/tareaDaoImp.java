package com.example.crudjava.dao;

import com.example.crudjava.exception.taskException;
import com.example.crudjava.models.tareas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Encargado de realizar los cambios de los datos del microservicio
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class tareaDaoImp implements tareaDao{

    @PersistenceContext
    private EntityManager entityManager;

    //Obtener tareas
    public List<tareas> getTareas() {
        String query = "From tareas";
        return entityManager.createQuery(query).getResultList();
    }


    //Registrar tarea
    @Override
    public ResponseEntity registrarTarea(tareas task) {
        if (task.getDescripcion().equals("") || task.getDescripcion() == null){
            throw new taskException("400", HttpStatus.BAD_REQUEST, "La descripción es requerida");
        }
        if (task.getEstatus().equals("") || task.getEstatus() == null){
            throw new taskException("400", HttpStatus.BAD_REQUEST, "El estado de la tarea es requerido");
        }
        if (task.getId() != null){
            throw new taskException("400", HttpStatus.BAD_REQUEST, "No puedes ingresar un ID");
        }
        entityManager.persist(task);
        return new ResponseEntity("La tarea fue registrada con éxito", HttpStatus.CREATED);
    }

    //Eliminar tarea
    @Override
    public void eliminarTarea(Long id) {
        tareas task = entityManager.find(tareas.class, id);
        entityManager.remove(task);
    }

    //Actualizar tarea
    @Override
    public void actualizarTarea(tareas task) {
        /*Query query = entityManager.createNativeQuery("UPDATE tareas SET descripcion = :newDescription, estado = :newStatus WHERE id = :id");
            query.setParameter("newDescription", task.getDescripcion());
            query.setParameter("newStatus" , task.getEstatus());
            query.setParameter("id", id);
            query.executeUpdate();*/
        entityManager.merge(task);
    }
}
