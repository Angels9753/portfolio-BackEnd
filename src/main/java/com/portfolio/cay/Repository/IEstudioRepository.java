
package com.portfolio.cay.Repository;

import com.portfolio.cay.Entity.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudioRepository extends JpaRepository<Estudio,Long>{
    public Optional<Estudio> findByTituloEs(String tituloEs );
    public boolean existsByTituloEs(String tituloEs);
}