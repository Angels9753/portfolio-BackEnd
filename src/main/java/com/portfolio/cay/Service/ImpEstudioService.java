
package com.portfolio.cay.Service;

import com.portfolio.cay.Entity.Estudio;
import com.portfolio.cay.Repository.IEstudioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEstudioService {
     @Autowired
    IEstudioRepository iEstudioRepository;
    
    public List<Estudio> list(){
        return iEstudioRepository.findAll();
    }
    
    public Optional<Estudio> getOne(Long id){
        return iEstudioRepository.findById(id);
    }
    
    public Optional<Estudio> getByTituloEs(String tituloEs){
        return iEstudioRepository.findByTituloEs(tituloEs);
    }
    
    public void save(Estudio est){
        iEstudioRepository.save(est);
    }
    
    public void delete(Long id){
        iEstudioRepository.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return iEstudioRepository.existsById(id);
    }
    
    public boolean existsByTituloEs(String tituloEs){
        return iEstudioRepository.existsByTituloEs(tituloEs);
    }
}
