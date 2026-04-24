package com.hospital.hospitalvm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ficha_paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichaPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "CLOB")
    private String historialAntecedentes;

    @OneToOne
    @JoinColumn(name = "id_paciente", unique = true)
    private Paciente paciente;
}
