/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenDR.practica.implementService;

import com.examenDR.practica.model.Alumno;
import com.examenDR.practica.repository.AlumnoRepository;
import com.examenDR.practica.service.AlumnoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author xeng_
 */
@Service
public class AlumnoImplementService implements AlumnoService{
    
    
    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @Override
    public void crearAlumno(Alumno alumno){
        Alumno alumno1 = alumnoRepository.findByNoControl(alumno.getNoControl());
        
        if(alumno1 != null){
           //alumno1.setGenero(alumno.getGenero());
           //alumno1.setAltura(alumno.getAltura());
           //alumno1.setCintura(alumno.getCintura());
           alumnoRepository.delete(alumno1);
       }
        
        alumnoRepository.save(alumno);
    }
    
    public Alumno getAlumno(Long noControl){
        return alumnoRepository.findByNoControl(noControl);
    }
    
    public List getAlumnos(){
        return alumnoRepository.findAll();
    }
    
    
}
