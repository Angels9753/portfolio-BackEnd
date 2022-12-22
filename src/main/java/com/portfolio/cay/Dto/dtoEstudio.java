package com.portfolio.cay.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoEstudio {
    @NotBlank
    private String institucionEs;
    @NotBlank
    private String tituloEs;
    @NotBlank
    private String desdeHastaEs;
    @NotBlank
    private String urlLogoEs;

    //Constructores

    public dtoEstudio() {
    }

    public dtoEstudio(String institucionEs, String tituloEs, String desdeHastaEs, String urlLogoEs) {
        this.institucionEs = institucionEs;
        this.tituloEs = tituloEs;
        this.desdeHastaEs = desdeHastaEs;
        this.urlLogoEs = urlLogoEs;
    }

    //Getters and setters
   
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
