package com.proclinic.erp.patient.entity.sub;

import com.proclinic.erp.patient.entity.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospitalisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateEntree;
    private LocalDate dateSortie;

    private String acte;
    private String medecinTraitant;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}