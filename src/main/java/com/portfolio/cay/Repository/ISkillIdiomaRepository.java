package com.portfolio.cay.Repository;

import com.portfolio.cay.Entity.SkillIdioma;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillIdiomaRepository extends JpaRepository<SkillIdioma, Long> {
    Optional<SkillIdioma> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
