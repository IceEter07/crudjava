package com.example.crudjava.controllers;

import com.example.crudjava.dao.tareaDao;
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

//    public ResponseEntity<taskResponseHttp> respuesta() {
//       taskResponseHttp taskResponse = new taskResponseHttp(1,"Consulta completada", "Petición correcta");
//       taskDao.getTareas();
//       return new ResponseEntity<taskResponseHttp>(taskResponse, HttpStatus.OK);
//   }

    //Obtener las tareas
    @GetMapping
    public List<tareas> getTask(){
        return taskDao.getTareas();
    }

    //Crear tareas
    //RequestBody sirve para deserializar un objeto a partir del cuerpo de la petición
    @PostMapping(consumes = {"*/*"})
    /*public void registrarTarea(@RequestBody tareas task){
        taskDao.registrarTarea(task);
    }*/
       public ResponseEntity<taskResponseHttp> respuesta(@RequestBody tareas task) {
        String registro = taskDao.registrarTarea(task);
        if(Objects.equals(registro, null)){
            taskResponseHttp taskResponse = new taskResponseHttp(1,"El registro se realizó exitosamente", "Correcto");
            return new ResponseEntity<taskResponseHttp>(taskResponse, HttpStatus.OK);
        }
       taskResponseHttp taskResponse = new taskResponseHttp(2,"El registro no se pudo llevar a cabo. El usuario inserto valores no válidos", "Incorrecto");
       return new ResponseEntity<taskResponseHttp>(taskResponse, HttpStatus.BAD_REQUEST);
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
