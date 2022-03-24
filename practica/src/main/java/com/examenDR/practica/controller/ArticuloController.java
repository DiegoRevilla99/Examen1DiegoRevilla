/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenDR.practica.controller;

import com.examenDR.practica.utils.CustomResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author xeng_
 */

@RestController
@RequestMapping("/api/v1/articulo")
public class ArticuloController {
    
    
    @PostMapping("/")
    public CustomResponse createArticulo(){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData("Post");
        //customResponse.setData(miArticulo);
        return customResponse;
    }
    
    @GetMapping("/")
    public CustomResponse getArticulo(){
        CustomResponse customResponse = new CustomResponse();

        customResponse.setData("Hola");
        return customResponse;
    }
    
    
    
    
    
}
