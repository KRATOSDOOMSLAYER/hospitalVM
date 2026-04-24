package com.hospital.hospitalvm.controller;

import com.hospital.hospitalvm.model.Medico;
import com.hospital.hospitalvm.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
@CrossOrigin(origins = "*")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<Medico>> listarTodos() {
        return ResponseEntity.ok(medicoService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Medico medico, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Medico nuevo = medicoService.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
}
