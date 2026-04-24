package com.hospital.hospitalvm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pacientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 13, nullable = false)
    @NotBlank(message = "El RUN es obligatorio")
    private String run;

    @Column(nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombres;

    @Column(nullable = false)
    @NotBlank(message = "El apellido es obligatorio")
    private String apellidos;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    private String diagnostico;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario tipoUsuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ficha_paciente_id")
    private FichaPaciente fichaPaciente;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Atencion> atenciones;
}
