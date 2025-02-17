package com.ApiRest.Repository;

import com.ApiRest.Entitys.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAlumno extends JpaRepository<Alumno, Long> {
}
