package com.hospital.hospitalvm.service;

import com.hospital.hospitalvm.model.Medico;
import com.hospital.hospitalvm.repository.MedicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Transactional(readOnly = true)
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Medico findById(Integer id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Medico> findByEspecialidad(String especialidad) {
        return medicoRepository.findByEspecialidadIgnoreCase(especialidad);
    }

    @Transactional
    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Transactional
    public void delete(Integer id) {
        medicoRepository.deleteById(id);
    }
}
