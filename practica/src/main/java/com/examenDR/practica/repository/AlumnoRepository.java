/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenDR.practica.repository;

import com.examenDR.practica.model.Alumno;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author xeng_
 */
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    
    public Alumno findByNoControl(Long noControl);
}
