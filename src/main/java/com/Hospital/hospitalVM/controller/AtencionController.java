package com.hospital.hospitalvm.controller;

import com.hospital.hospitalvm.service.AtencionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/atenciones")
@CrossOrigin(origins = "*")
public class AtencionController {

    private final AtencionService atencionService;

    public AtencionController(AtencionService atencionService) {
        this.atencionService = atencionService;
    }

    @GetMapping("/costos/{tipo}")
    public ResponseEntity<Double> obtenerCostosPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(atencionService.obtenerTotalCostosPorTipo(tipo));
    }
}
