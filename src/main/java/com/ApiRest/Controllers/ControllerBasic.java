package com.ApiRest.Controllers;

import com.ApiRest.Entitys.Alumno;
import com.ApiRest.Repository.RepositoryAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/home/api")
public class ControllerBasic {

    @Autowired
    private RepositoryAlumno repositoryAlumno;

    @GetMapping()
    public String getDAta(){
        return "Conectado";
    }

    @GetMapping("/alumnos")
    public List<Alumno> getAlumnos(){
        return repositoryAlumno.findAll();
    }

    @PostMapping("/crear")
    @Transactional
    public String postAlumnos(@RequestBody Alumno alumno){
        repositoryAlumno.save(alumno);
        return "Guardado";
    }

    @PutMapping("/editar/{id}")
    public String putAlumno(@PathVariable Long id, @RequestBody Alumno alumno){
        Alumno editarAlumno = repositoryAlumno.findById(id).get();
        editarAlumno.setNombre(alumno.getNombre());
        editarAlumno.setTelefono(alumno.getTelefono());
        repositoryAlumno.save(editarAlumno);
        return "Cambio Guardado";
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteAlumno(@PathVariable Long id){
        Alumno deleteAlumno = repositoryAlumno.findById(id).get();
        repositoryAlumno.delete(deleteAlumno);
        return "Eliminado";
    }
}
