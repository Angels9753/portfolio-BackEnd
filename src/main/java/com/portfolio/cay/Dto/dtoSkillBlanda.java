package com.portfolio.cay.Dto;

import jakarta.validation.constraints.NotBlank;


public class dtoSkillBlanda {
    @NotBlank
   private String nombre;
    @NotBlank
    private String porcentaje;
    @NotBlank
    private String color;

    public dtoSkillBlanda() {
    }

    public dtoSkillBlanda(String nombre, String porcentaje, String color) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
}
