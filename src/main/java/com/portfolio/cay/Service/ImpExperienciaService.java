
package com.portfolio.cay.Service;

import com.portfolio.cay.Entity.Experiencia;
import com.portfolio.cay.Repository.IExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaService {
    @Autowired
     IExperienciaRepository iExperienciaRepository;
     
     public List<Experiencia> list(){
         return iExperienciaRepository.findAll();
     }
     
     public Optional<Experiencia> getOne(Long id){
         return iExperienciaRepository.findById(id);
     }
     
     public Optional<Experiencia> getByCargoEx(String cargoEx){
         return iExperienciaRepository.findByCargoEx(cargoEx);
     }
     
     public void save(Experiencia exp){
         iExperienciaRepository.save(exp);
     }
     
     public void delete(Long id){
         iExperienciaRepository.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return iExperienciaRepository.existsById(id);
     }
     
     public boolean existsByCargoEx(String cargoEx){
         return iExperienciaRepository.existsByCargoEx(cargoEx);
     }
}
