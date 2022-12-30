
package com.portfolio.cay.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;


@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min=1, max=50, message="longitud de 1 a 50 caracteres")
    private String nombre;
    
    @NotNull
    @Size(min=1, max=50, message="longitud de 1 a 50 caracteres")
    private String apellido;
    
    @Size(min=1, max=150, message="longitud de 1 a 150 caracteres")
    private String img;
    
    @Size(min=1, max=80, message="longitud de 1 a 80 caracteres")
    private String subtitulo;
    
    @Size(min=1, max=660, message="longitud de 1 a 670 caracteres")
    private String descripcion;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String subtitulo, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.subtitulo = subtitulo;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
