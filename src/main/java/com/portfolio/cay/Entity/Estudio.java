package com.portfolio.cay.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String institucionEs;
    private String tituloEs;
    private String desdeHastaEs;
    private String urlLogoEs;
    
    //Constructores
    public Estudio() {
    }

    public Estudio(String institucionEs, String tituloEs, String desdeHastaEs, String urlLogoEs) {
        this.institucionEs = institucionEs;
        this.tituloEs = tituloEs;
        this.desdeHastaEs = desdeHastaEs;
        this.urlLogoEs = urlLogoEs;
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitucionEs() {
        return institucionEs;
    }

    public void setInstitucionEs(String institucionEs) {
        this.institucionEs = institucionEs;
    }

    public String getTituloEs() {
        return tituloEs;
    }

    public void setTituloEs(String tituloEs) {
        this.tituloEs = tituloEs;
    }

    public String getDesdeHastaEs() {
        return desdeHastaEs;
    }

    public void setDesdeHastaEs(String desdeHastaEs) {
        this.desdeHastaEs = desdeHastaEs;
    }

    public String getUrlLogoEs() {
        return urlLogoEs;
    }

    public void setUrlLogoEs(String urlLogoEs) {
        this.urlLogoEs = urlLogoEs;
    }

}
