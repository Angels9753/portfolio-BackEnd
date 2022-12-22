package com.portfolio.cay.Service;

import com.portfolio.cay.Entity.SkillBlanda;
import com.portfolio.cay.Repository.ISkillBlandaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ImpSkillBlandaService {

    @Autowired
    ISkillBlandaRepository iSkillBlandaRepository;

    public List<SkillBlanda> list() {
        return iSkillBlandaRepository.findAll();
    }

    public Optional<SkillBlanda> getOne(Long id) {
        return iSkillBlandaRepository.findById(id);
    }

    public Optional<SkillBlanda> getByNombre(String nombre) {
        return iSkillBlandaRepository.findByNombre(nombre);
    }

    public void save(SkillBlanda skbl) {
        iSkillBlandaRepository.save(skbl);
    }

    public void delete(Long id) {
        iSkillBlandaRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return iSkillBlandaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iSkillBlandaRepository.existsByNombre(nombre);
    }
}
