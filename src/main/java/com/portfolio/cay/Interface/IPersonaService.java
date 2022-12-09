
package com.portfolio.cay.Interface;

import com.portfolio.cay.Entity.Persona;
import java.util.List;

public interface IPersonaService {
   //Traer una lista de personas
   public List<Persona> getPersona();
    
   //guardar un objeto de tipo Perosna
   public void savePersona(Persona persona);
   
   //Eliminar un objeto Persona por id
   public void deletePersona(Long id);
   
   //Buscar un objeto Persona por id
   public Persona findPersona(Long id);
}
