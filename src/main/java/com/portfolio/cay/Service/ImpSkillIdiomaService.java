
package com.portfolio.cay.Service;

import com.portfolio.cay.Entity.SkillIdioma;
import com.portfolio.cay.Repository.ISkillIdiomaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ImpSkillIdiomaService {

    @Autowired
    ISkillIdiomaRepository iSkillIdiomaRepository;

    public List<SkillIdioma> list() {
        return iSkillIdiomaRepository.findAll();
    }

    public Optional<SkillIdioma> getOne(Long id) {
        return iSkillIdiomaRepository.findById(id);
    }

    public Optional<SkillIdioma> getByNombre(String nombre) {
        return iSkillIdiomaRepository.findByNombre(nombre);
    }

    public void save(SkillIdioma skbi) {
        iSkillIdiomaRepository.save(skbi);
    }

    public void delete(Long id) {
        iSkillIdiomaRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return iSkillIdiomaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iSkillIdiomaRepository.existsByNombre(nombre);
    }
}
