package com.hospital.hospitalvm.repository;

import com.hospital.hospitalvm.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByRun(String run);
}
