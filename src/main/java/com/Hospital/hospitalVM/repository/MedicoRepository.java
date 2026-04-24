package com.hospital.hospitalvm.repository;

import com.hospital.hospitalvm.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    List<Medico> findByEspecialidadIgnoreCase(String especialidad);
}
