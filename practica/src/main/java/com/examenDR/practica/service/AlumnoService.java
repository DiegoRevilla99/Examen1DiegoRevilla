/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenDR.practica.service;

import com.examenDR.practica.model.Alumno;
import java.util.List;

/**
 *
 * @author xeng_
 */
public interface AlumnoService {
    
    public void crearAlumno(Alumno alumno);
    public Alumno getAlumno(Long noControl);
    public List getAlumnos();
    
}
