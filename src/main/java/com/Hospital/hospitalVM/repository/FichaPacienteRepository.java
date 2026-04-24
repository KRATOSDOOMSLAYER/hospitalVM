package com.hospital.hospitalvm.repository;

import com.hospital.hospitalvm.model.FichaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaPacienteRepository extends JpaRepository<FichaPaciente, Long> {
}
