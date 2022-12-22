
package com.portfolio.cay.Service;

import com.portfolio.cay.Entity.SkillDura;
import com.portfolio.cay.Repository.ISkillDuraRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ImpSkillDuraService {

    @Autowired
    ISkillDuraRepository iSkillDuraRepository;

    public List<SkillDura> list() {
        return iSkillDuraRepository.findAll();
    }

    public Optional<SkillDura> getOne(Long id) {
        return iSkillDuraRepository.findById(id);
    }

    public Optional<SkillDura> getByNombre(String nombre) {
        return iSkillDuraRepository.findByNombre(nombre);
    }

    public void save(SkillDura skbd) {
        iSkillDuraRepository.save(skbd);
    }

    public void delete(Long id) {
        iSkillDuraRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return iSkillDuraRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iSkillDuraRepository.existsByNombre(nombre);
    }
}
