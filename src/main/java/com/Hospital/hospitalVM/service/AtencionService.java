package com.hospital.hospitalvm.service;

import com.hospital.hospitalvm.model.Atencion;
import com.hospital.hospitalvm.repository.AtencionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AtencionService {

    private final AtencionRepository atencionRepository;

    public AtencionService(AtencionRepository atencionRepository) {
        this.atencionRepository = atencionRepository;
    }

    @Transactional(readOnly = true)
    public Double obtenerTotalCostosPorTipo(String tipo) {
        Double total = atencionRepository.sumCostoByTipoUsuario(tipo);
        return (total != null) ? total : 0.0;
    }

    @Transactional(readOnly = true)
    public List<Atencion> obtenerHistorialCronologico(String run) {
        return atencionRepository.findByPacienteRunOrderByFechaAtencionAsc(run);
    }

    @Transactional(readOnly = true)
    public List<Atencion> findAll() {
        return atencionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Atencion findById(Integer id) {
        return atencionRepository.findById(id).orElse(null);
    }

    @Transactional
    public Atencion save(Atencion atencion) {
        return atencionRepository.save(atencion);
    }

    @Transactional
    public void delete(Integer id) {
        atencionRepository.deleteById(id);
    }
}
