/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenDR.practica.controller;

import com.examenDR.practica.implementService.AlumnoImplementService;
import com.examenDR.practica.model.Alumno;
import com.examenDR.practica.utils.CustomResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author xeng_
 */

@RestController
@RequestMapping("/api/v1/alumno")
public class AlumnoController {
    
    @Autowired
    private AlumnoImplementService alumnoImplementService;
    
    @PostMapping("/")
    public CustomResponse createAlumno(@RequestBody Alumno alumno){
        CustomResponse customResponse = new CustomResponse();
        
        if(alumno.getNoControl() == null){
            customResponse.setHttpCode(400);
            customResponse.setMensaje("El numero de control es requerido");
            return customResponse;
        }
        
        if(Long.toString(alumno.getNoControl()).length() != 8 ){
            customResponse.setHttpCode(400);
            customResponse.setMensaje("El numero de control debe tener 8 dígitos");
            return customResponse;
        }
        
        
        alumnoImplementService.crearAlumno(alumno);
        return customResponse;
    }
    
    @GetMapping("/")
    public CustomResponse getAlumnos(){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData(alumnoImplementService.getAlumnos());
        return customResponse;
    }
    
    @GetMapping("/{noControl}")
    public CustomResponse getAlumno(@PathVariable("noControl") Long noControl){
        CustomResponse customResponse = new CustomResponse();
        Alumno alumno = alumnoImplementService.getAlumno(noControl);
        if(alumno.getAltura() == 0 || alumno.getCintura()== 0 || alumno.getGenero() == '\u0000'){
            customResponse.setHttpCode(400);
            customResponse.setMensaje("No se cuentan con los datos necesarios para realizar el calculo");
            return customResponse;
        }
        
        double ica = alumno.getCintura() / alumno.getAltura();
        String nivel = "";
        if(alumno.getGenero() == 'H'){
            if(ica < 0.34) nivel= "Delgadez severa";
            else if(ica >= 0.35 && ica < 0.42) nivel = "Delgadez leve";
            else if(ica >= 0.43 && ica < 0.52) nivel = "Peso normal";
            else if(ica >= 0.53 && ica < 0.57) nivel = "Sobrepeso";
            else if(ica >= 0.58 && ica < 0.62) nivel = "Sobrepeso Elevado";
            else if(ica >= 0.63) nivel = "Obesidad mórbida";
        }
        
        if(alumno.getGenero() == 'M'){
            if(ica < 0.34) nivel = "Delgadez severa";
            else if(ica >= 0.35 && ica < 0.41) nivel = "Delgadez leve";
            else if(ica >= 0.42 && ica < 0.48) nivel = "Peso normal";
            else if(ica >= 0.49 && ica < 0.53) nivel = "Sobrepeso";
            else if(ica >= 0.54 && ica < 0.57) nivel = "Sobrepeso Elevado";
            else if(ica >= 0.58) nivel = "Obesidad mórbida";
        }
        
        List<Object> lista = new ArrayList();
        lista.add("ica: " +  ica);
        lista.add("nivel: " +  nivel);
        customResponse.setData(lista);
        return customResponse;
    }
    
}
