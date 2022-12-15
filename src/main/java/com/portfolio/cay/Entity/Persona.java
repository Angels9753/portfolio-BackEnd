
package com.portfolio.cay.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;



/*Genera en forma automatica los Get&Set con Lombok*/
@Getter @Setter 
@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
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
    
    @Size(min=1, max=650, message="longitud de 1 a 650 caracteres")
    private String descripcion;
    
    @NotNull
    @Size(min=5, max=10, message="longitud de 5 a 10 caracteres")
    private String usr;
    
    @NotNull
    @Size(min=5, max=20, message="longitud de 5 a 20 caracteres")
    private String password;
      
    private boolean admin;

   
    
}
