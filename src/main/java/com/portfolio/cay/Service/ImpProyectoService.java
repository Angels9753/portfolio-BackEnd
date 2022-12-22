
package com.portfolio.cay.Service;

import com.portfolio.cay.Entity.Proyecto;
import com.portfolio.cay.Repository.IProyectoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectoService {
    @Autowired
     IProyectoRepository iProyectoRepository;
     
     public List<Proyecto> list(){
         return iProyectoRepository.findAll();
     }
     
     public Optional<Proyecto> getOne(Long id){
         return iProyectoRepository.findById(id);
     }
     
     public Optional<Proyecto> getByInstitucionPr(String institucionPr){
         return iProyectoRepository.findByInstitucionPr(institucionPr);
     }
     
     public void save(Proyecto pro){
         iProyectoRepository.save(pro);
     }
     
     public void delete(Long id){
         iProyectoRepository.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return iProyectoRepository.existsById(id);
     }
     
     public boolean existsByInstitucionPr(String institucionPr){
         return iProyectoRepository.existsByInstitucionPr(institucionPr);
     }
}
