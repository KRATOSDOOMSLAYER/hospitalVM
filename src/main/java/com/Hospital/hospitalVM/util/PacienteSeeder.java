package com.hospital.hospitalvm.util;

import com.hospital.hospitalvm.model.*;
import com.hospital.hospitalvm.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class PacienteSeeder implements CommandLineRunner {
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;
    private final AtencionRepository atencionRepository;
    private final FichaPacienteRepository fichaPacienteRepository;

    public PacienteSeeder(PacienteRepository pacienteRepository, 
                          MedicoRepository medicoRepository,
                          TipoUsuarioRepository tipoUsuarioRepository,
                          AtencionRepository atencionRepository,
                          FichaPacienteRepository fichaPacienteRepository) {
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
        this.atencionRepository = atencionRepository;
        this.fichaPacienteRepository = fichaPacienteRepository;
    }

    @Override
    public void run(String... args) {
        // 1. Crear Tipos de Usuario
        TipoUsuario fonasa = tipoUsuarioRepository.save(new TipoUsuario(null, "FONASA", new ArrayList<>()));
        TipoUsuario isapre = tipoUsuarioRepository.save(new TipoUsuario(null, "ISAPRE", new ArrayList<>()));

        // 2. Crear Fichas Médicas
        FichaPaciente ficha1 = fichaPacienteRepository.save(new FichaPaciente(null, "Paciente con antecedentes de hipertensión.", null));
        FichaPaciente ficha2 = fichaPacienteRepository.save(new FichaPaciente(null, "Paciente alérgico a la penicilina.", null));

        // 3. Crear Pacientes vinculados
        Paciente p1 = new Paciente(null, "11111111-1", "Juan", "Pérez", LocalDate.of(1985, 5, 20), "juan.perez@email.com", "Chequeo general", fonasa, ficha1, new ArrayList<>());
        Paciente p2 = new Paciente(null, "22222222-2", "María", "González", LocalDate.of(1995, 10, 15), "maria.g@email.com", "Migraña", isapre, ficha2, new ArrayList<>());
        
        p1 = pacienteRepository.save(p1);
        p2 = pacienteRepository.save(p2);

        // 4. Crear Médicos
        Medico m1 = medicoRepository.save(new Medico(null, "33333333-3", "Carlos", "López", "Cardiología"));
        Medico m2 = medicoRepository.save(new Medico(null, "44444444-4", "Ana", "Martínez", "Pediatría"));

        // 5. Crear Atenciones/Costos vinculados
        atencionRepository.save(new Atencion(null, java.time.LocalDateTime.now(), 15000.0, "Consulta inicial", p1, m1));
        atencionRepository.save(new Atencion(null, java.time.LocalDateTime.now(), 25000.0, "Seguimiento", p1, m2));
        atencionRepository.save(new Atencion(null, java.time.LocalDateTime.now(), 45000.0, "Urgencia", p2, m1));

        System.out.println("Ecosistema de datos 'Pro' sincronizado con Postman cargado exitosamente.");
    }
}
