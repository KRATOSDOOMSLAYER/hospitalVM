package com.hospital.hospitalvm.repository;

import com.hospital.hospitalvm.model.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Integer> {
    
    @Query("SELECT SUM(a.costo) FROM Atencion a JOIN a.paciente p JOIN p.tipoUsuario t WHERE UPPER(t.nombreTipo) = UPPER(:tipo)")
    Double sumCostoByTipoUsuario(@Param("tipo") String tipo);

    List<Atencion> findByPacienteRunOrderByFechaAtencionAsc(String run);
}
