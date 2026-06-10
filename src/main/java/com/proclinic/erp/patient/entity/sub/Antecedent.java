package com.proclinic.erp.patient.entity.sub;

import com.proclinic.erp.patient.entity.Patient;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Antecedent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String type;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}