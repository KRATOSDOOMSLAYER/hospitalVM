package com.hospital.hospitalvm.service;

import com.hospital.hospitalvm.model.Paciente;
import com.hospital.hospitalvm.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional(readOnly = true)
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Paciente findById(Integer id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Transactional
    public Paciente save(Paciente paciente) {
        if (paciente.getId() == null) {
            Paciente existente = pacienteRepository.findByRun(paciente.getRun());
            if (existente != null) {
                throw new IllegalArgumentException("El RUN ya está registrado.");
            }
        }
        return pacienteRepository.save(paciente);
    }

    @Transactional
    public boolean delete(Integer id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    public Paciente obtenerHistorialCompleto(Integer id) {
        return pacienteRepository.findById(id).orElse(null);
    }
}
