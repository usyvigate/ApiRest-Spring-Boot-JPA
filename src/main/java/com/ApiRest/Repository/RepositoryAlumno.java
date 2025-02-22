package com.ApiRest.Repository;

import com.ApiRest.Entitys.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAlumno extends JpaRepository<Alumno, Long> {

    //Query method
    public Alumno findByUserAndPassword(String user, String password);
}
