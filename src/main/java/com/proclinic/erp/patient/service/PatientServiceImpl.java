package com.proclinic.erp.patient.service;

import com.proclinic.erp.common.utils.CodeGenerator;
import com.proclinic.erp.patient.dto.InsuranceInfoResponse;
import com.proclinic.erp.patient.dto.MedicalRecordResponse;
import com.proclinic.erp.patient.dto.PatientRequest;
import com.proclinic.erp.patient.dto.PatientResponse;
import com.proclinic.erp.patient.entity.Patient;
import com.proclinic.erp.patient.entity.PatientStatus;
import com.proclinic.erp.patient.entity.sub.MedicalRecord;
import com.proclinic.erp.patient.repository.MedicalRecordRepository;
import com.proclinic.erp.patient.repository.PatientRepository;
import com.proclinic.erp.settings.city.City;
import com.proclinic.erp.settings.insurance.entity.Insurance;
import com.proclinic.erp.settings.profession.entity.Profession;
import com.proclinic.erp.settings.city.CityRepository;
import com.proclinic.erp.settings.profession.repository.ProfessionRepository;
import com.proclinic.erp.settings.insurance.repository.InsuranceRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final MedicalRecordRepository medicalRecordRepository;
    private final CityRepository cityRepository;
    private final ProfessionRepository professionRepository;
    private final InsuranceRepository insuranceRepository;

    // ⚠️ simple compteur (plus tard tu peux remplacer par sequence DB)
    private static final AtomicInteger counter = new AtomicInteger(1);

    @Override
    public List<PatientResponse> getAll() {
        return patientRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PatientResponse getById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        return mapToResponse(patient);
    }

    @Override
    @Transactional
    public PatientResponse create(PatientRequest request) {

        // 🔥 1. Generate patient code
        String patientCode = generatePatientCode();

        // 🔥 2. Build patient
        Patient patient = Patient.builder()
                .patientCode(CodeGenerator.generate("PAT"))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .sex(request.getSex())
                .dateOfBirth(request.getDateOfBirth())
                .phone(request.getPhone())
                .email(request.getEmail())
                .status(PatientStatus.ACTIVE)
                .address(request.getAddress())
                // 🔗 relations
                .city(mapCity(request.getCityId()))
                .profession(mapProfession(request.getProfessionId()))
                .insurance(mapInsurance(request.getInsuranceId()))
                .cin(request.getCin())
                .build();

        // 🔥 3. Save patient
        Patient savedPatient = patientRepository.save(patient);

        // 🔥 4. Create medical record automatically
        MedicalRecord medicalRecord = MedicalRecord.builder()
                .medicalRecordCode(CodeGenerator.generate("MED"))
                .patient(savedPatient)
                .build();

        medicalRecordRepository.save(medicalRecord);

        return mapToResponse(savedPatient);
    }

    @Override
    public PatientResponse update(Long id, PatientRequest request) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setSex(request.getSex());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setPhone(request.getPhone());
        patient.setEmail(request.getEmail());
        patient.setCity(mapCity(request.getCityId()));
        patient.setProfession(mapProfession(request.getProfessionId()));
        patient.setInsurance(mapInsurance(request.getInsuranceId()));
        patient.setAddress(request.getAddress());
        return mapToResponse(patientRepository.save(patient));
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    // =========================
    // 🔥 MAPPERS
    // =========================

    private PatientResponse mapToResponse(Patient patient) {
        MedicalRecord medicalRecord =
                medicalRecordRepository.findByPatientId(patient.getId())
                        .orElse(null);
        return PatientResponse.builder()

                .id(patient.getId())
                .patientCode(patient.getPatientCode())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .dateOfBirth(patient.getDateOfBirth())
                .sex(patient.getSex())
                .phone(patient.getPhone())
                .email(patient.getEmail())
                .address(patient.getAddress())
                .cin(patient.getCin())
                // safe enum
                .status(patient.getStatus() != null ? patient.getStatus().name() : null)

                // relations (safe)
                .cityName(patient.getCity() != null ? patient.getCity().getName() : null)
                .professionName(patient.getProfession() != null ? patient.getProfession().getName() : null)
//                .insuranceName(patient.getInsurance() != null ? patient.getInsurance().getName() : null)
                .medicalRecord(
                        medicalRecord != null
                                ? MedicalRecordResponse.builder()
                                .medicalRecordCode(medicalRecord.getMedicalRecordCode())
                                .medicalHistory(medicalRecord.getMedicalHistory())
                                .allergies(medicalRecord.getAllergies())
                                .bloodGroup(medicalRecord.getBloodGroup())
                                .build()
                                : null)
                .insurance(
                        patient.getInsurance() != null
                                ? InsuranceInfoResponse.builder()
                                .id(patient.getInsurance().getId())
                                .name(patient.getInsurance().getName())
                                .matricule(patient.getInsurance().getMatricule())
                                .affiliation(patient.getInsurance().getAffiliation())
                                .type(patient.getInsurance().getType().name())
                                .status(patient.getInsurance().getStatus().name())
                                .build()
                                : null
                )

                .build();
    }

    // =========================
    // 🔥 CODE GENERATORS
    // =========================

    private String generatePatientCode() {
        return "PAT-2026-" + String.format("%03d", counter.getAndIncrement());
    }

    private String generateMedicalRecordCode() {
        return "MED-2026-" + String.format("%03d", counter.getAndIncrement());
    }

    // =========================
    // 🔥 MAPPINGS SETTINGS
    // =========================

    private City mapCity(Long id) {
        if (id == null) return null;

        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));
    }

    private Profession mapProfession(Long id) {
        if (id == null) return null;

        return professionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profession not found"));
    }

    private Insurance mapInsurance(Long id) {
        if (id == null) return null;

        return insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));
    }
}