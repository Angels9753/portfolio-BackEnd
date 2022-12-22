package com.portfolio.cay.Repository;

import com.portfolio.cay.Entity.SkillBlanda;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillBlandaRepository extends JpaRepository<SkillBlanda, Long> {
    Optional<SkillBlanda> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
