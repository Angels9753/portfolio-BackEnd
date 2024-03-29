
package com.portfolio.cay.Repository;

import com.portfolio.cay.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto,Long>{
        public Optional<Proyecto> findByInstitucionPr(String institucionPr);
    public boolean existsByInstitucionPr(String institucionPr);
}