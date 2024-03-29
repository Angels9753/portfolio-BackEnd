
package com.portfolio.cay.Service;

import com.portfolio.cay.Entity.Persona;
import com.portfolio.cay.Repository.IPersonaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService {
    @Autowired  IPersonaRepository iPersonaRepository;
    
    public List<Persona> list(){
         return iPersonaRepository.findAll();
     }
     
     public Optional<Persona> getOne(int id){
         return iPersonaRepository.findById(id);
     }
     
     public Optional<Persona> getByNombre(String nombre){
         return iPersonaRepository.findByNombre(nombre);
     }
     
     public void save(Persona persona){
         iPersonaRepository.save(persona);
     }
     
     public void delete(int id){
         iPersonaRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iPersonaRepository.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return iPersonaRepository.existsByNombre(nombre);
     }
}
