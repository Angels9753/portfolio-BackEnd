package com.portfolio.cay.Repository;

import com.portfolio.cay.Entity.SkillDura;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillDuraRepository extends JpaRepository<SkillDura, Long> {
    Optional<SkillDura> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
