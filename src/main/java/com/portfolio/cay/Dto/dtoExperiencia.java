package com.portfolio.cay.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
     private String institucionEx;
    @NotBlank
    private String cargoEx;
    @NotBlank
    private String descripcionEx;
    @NotBlank
    private String desdeHastaEx;
    @NotBlank
    private String iconoEx;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String institucionEx, String cargoEx, String descripcionEx, String desdeHastaEx, String iconoEx) {
        this.institucionEx = institucionEx;
        this.cargoEx = cargoEx;
        this.descripcionEx = descripcionEx;
        this.desdeHastaEx = desdeHastaEx;
        this.iconoEx = iconoEx;
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
