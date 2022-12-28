/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.cay.Dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Angel Cay
 */
public class dtoPersona {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String img;
    @NotBlank
    private String subtitulo;
    @NotBlank
    private String descripcion;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String img, String subtitulo, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.subtitulo = subtitulo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
