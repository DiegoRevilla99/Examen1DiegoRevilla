/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenDR.practica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author xeng_
 */
@Entity
@Table(name = "alumno")
public class Alumno {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAlumno;
    private Long noControl;
    private char genero = 'x';
    private double cintura = 0;
    private double altura = 0;

    public Long getNoControl() {
        return noControl;
    }

    public void setNoControl(Long noControl) {
        this.noControl = noControl;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    
    

    @Override
    public String toString() {
        return "Alumno{" + "noControl=" + noControl + ", genero=" + genero + ", cintura=" + cintura + ", altura=" + altura + '}';
    }
    
    
    
}
