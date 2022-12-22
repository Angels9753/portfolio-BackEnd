package com.portfolio.cay.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String institucionEx;
    private String cargoEx;
    private String descripcionEx;
    private String desdeHastaEx;
    private String iconoEx;
    
    //Constructores
    public Experiencia() {
    }

    public Experiencia(String institucionEx, String cargoEx, String descripcionEx, String desdeHastaEx, String iconoEx) {
        this.institucionEx = institucionEx;
        this.cargoEx = cargoEx;
        this.descripcionEx = descripcionEx;
        this.desdeHastaEx = desdeHastaEx;
        this.iconoEx = iconoEx;
    }


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitucionEx() {
        return institucionEx;
    }

    public void setInstitucionEx(String institucionEx) {
        this.institucionEx = institucionEx;
    }

    public String getCargoEx() {
        return cargoEx;
    }

    public void setCargoEx(String cargoEx) {
        this.cargoEx = cargoEx;
    }

    public String getDescripcionEx() {
        return descripcionEx;
    }

    public void setDescripcionEx(String descripcionEx) {
        this.descripcionEx = descripcionEx;
    }

    public String getDesdeHastaEx() {
        return desdeHastaEx;
    }

    public void setDesdeHastaEx(String desdeHastaEx) {
        this.desdeHastaEx = desdeHastaEx;
    }

    public String getIconoEx() {
        return iconoEx;
    }

    public void setIconoEx(String iconoEx) {
        this.iconoEx = iconoEx;
    }
    
}
