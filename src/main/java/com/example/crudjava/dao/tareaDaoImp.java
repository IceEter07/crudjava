package com.example.crudjava.dao;

import com.example.crudjava.models.tareas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
    @Override
    public List<tareas> getTareas() {
        String query = "From tareas";
        return entityManager.createQuery(query).getResultList();
    }
    /*public ResponseEntity<List<tareas>> getTareas() {
        return new ResponseEntity<>();
    }*/



    //Registrar tarea
    @Override
    public void registrarTarea(tareas task) {
        entityManager.persist(task);
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
