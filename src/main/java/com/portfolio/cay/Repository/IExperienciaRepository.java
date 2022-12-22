package com.portfolio.cay.Repository;

import com.portfolio.cay.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long> {
    public Optional<Experiencia> findByCargoEx(String cargoEx);
    public boolean existsByCargoEx(String cargoEx);
}
