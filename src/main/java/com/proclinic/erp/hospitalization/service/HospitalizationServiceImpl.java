package com.proclinic.erp.hospitalization.service;

import com.proclinic.erp.common.utils.CodeGenerator;
import com.proclinic.erp.hospitalization.dto.*;
import com.proclinic.erp.hospitalization.entity.*;
import com.proclinic.erp.hospitalization.repository.HospitalizationRepository;
import com.proclinic.erp.hospitalization.service.HospitalizationService;
import com.proclinic.erp.patient.entity.Patient;
import com.proclinic.erp.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HospitalizationServiceImpl implements HospitalizationService {

    private final HospitalizationRepository hospitalizationRepository;
    private final PatientRepository patientRepository;

    // ========================= CREATE =========================
    @Override
    @Transactional
    public HospitalizationResponse create(HospitalizationRequest request) {

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Hospitalization hosp = Hospitalization.builder()
                .hospitalizationCode(CodeGenerator.generate("HOSP"))
                .patient(patient)
                .patientName(patient.getFirstName() + " " + patient.getLastName())
                .admissionDate(request.getAdmissionDate())
                .dischargeDate(request.getDischargeDate())
                .roomNumber(request.getRoomNumber())
                .status(request.getStatus())
                .intensiveCareDays(request.getIntensiveCareDays())
                .reanimationDays(request.getReanimationDays())
                .incubatorDays(request.getIncubatorDays())
                .observations(request.getObservations())
                .treatingDoctor(request.getTreatingDoctor())
                .insurance(patient.getInsurance() != null
                        ? patient.getInsurance().getName()
                        : null)
                .acts(mapActs(request.getActs()))
                .build();

        calculateBilling(hosp);

        Hospitalization saved = hospitalizationRepository.save(hosp);

        return mapToResponse(saved);
    }

    // ========================= GET BY ID =========================
    @Override
    public HospitalizationResponse getById(Long id) {

        Hospitalization hosp = hospitalizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospitalization not found"));

        return mapToResponse(hosp);
    }

    // ========================= GET ALL =========================
    @Override
    public List<HospitalizationResponse> getAll() {

        return hospitalizationRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ========================= UPDATE =========================
    @Override
    @Transactional
    public HospitalizationResponse update(Long id, HospitalizationRequest request) {

        Hospitalization hosp = hospitalizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospitalization not found"));

        hosp.setAdmissionDate(request.getAdmissionDate());
        hosp.setDischargeDate(request.getDischargeDate());
        hosp.setRoomNumber(request.getRoomNumber());
        hosp.setStatus(request.getStatus());
        hosp.setIntensiveCareDays(request.getIntensiveCareDays());
        hosp.setReanimationDays(request.getReanimationDays());
        hosp.setIncubatorDays(request.getIncubatorDays());
        hosp.setObservations(request.getObservations());
        hosp.setTreatingDoctor(request.getTreatingDoctor());

        hosp.getActs().clear();
        hosp.getActs().addAll(
                mapActs(request.getActs())
        );
        //hosp.setActs(mapActs(request.getActs()));

        calculateBilling(hosp);

        Hospitalization updated = hospitalizationRepository.save(hosp);

        return mapToResponse(updated);
    }

    // ========================= DELETE =========================
    @Override
    public String delete(Long id) {

        Hospitalization hosp = hospitalizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospitalization not found"));

        hosp.setIsDeleted(true);
        hosp.setDeletedAt(LocalDateTime.now());

        hospitalizationRepository.save(hosp);
        return "Hospitalization deleted successfully";
    }

    // ========================= GET BY PATIENT =========================
    @Override
    public List<HospitalizationResponse> getByPatientId(Long patientId) {

        return hospitalizationRepository.findByPatientId(patientId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ========================= BILLING =========================
    private void calculateBilling(Hospitalization hosp) {

        double actsTotal = hosp.getActs() != null
                ? hosp.getActs().stream()
                .mapToDouble(a -> a.getQuotation() * a.getQuantity())
                .sum()
                : 0;

        double total = actsTotal
                + (hosp.getIntensiveCareDays() != null ? hosp.getIntensiveCareDays() * 1400 : 0)
                + (hosp.getReanimationDays() != null ? hosp.getReanimationDays() * 2200 : 0)
                + (hosp.getIncubatorDays() != null ? hosp.getIncubatorDays() * 750 : 0);

        double insurance = total * 0.70;
        double patient = total - insurance;

        HospitalizationBilling billing = new HospitalizationBilling();
        billing.setHospitalizationAmount(total);
        billing.setInsuranceAmount(insurance);
        billing.setPatientAmount(patient);

        hosp.setBilling(billing);
    }

    // ========================= MAPPING ACTS =========================
    private List<HospitalizationAct> mapActs(List<HospitalizationActDto> acts) {

        if (acts == null) return List.of();

        return acts.stream().map(a -> {
            HospitalizationAct act = new HospitalizationAct();
            act.setActName(a.getActName());
            act.setAmoCode(a.getAmoCode());
            act.setQuotation(a.getQuotation());
            act.setQuantity(a.getQuantity());
            act.setTotal(a.getQuotation() * a.getQuantity());
            return act;
        }).collect(Collectors.toList());
    }

    // ========================= RESPONSE MAPPER =========================
    private HospitalizationResponse mapToResponse(Hospitalization h) {

        return HospitalizationResponse.builder()
                .id(h.getId())
                .patientId(h.getPatient().getId())
                .patientName(h.getPatientName())
                .admissionDate(h.getAdmissionDate())
                .dischargeDate(h.getDischargeDate())
                .roomNumber(h.getRoomNumber())
                .status(h.getStatus())
                .intensiveCareDays(h.getIntensiveCareDays())
                .reanimationDays(h.getReanimationDays())
                .incubatorDays(h.getIncubatorDays())
                .observations(h.getObservations())
                .treatingDoctor(h.getTreatingDoctor())
                .insurance(h.getInsurance())
                .acts(h.getActs())
                .billing(h.getBilling())
                .build();
    }

    // pour ajouter un act
    @Transactional
    public HospitalizationResponse addAct(Long hospitalizationId,
                                          HospitalizationActDto request) {

        Hospitalization hosp = hospitalizationRepository.findById(hospitalizationId)
                .orElseThrow(() -> new RuntimeException("Hospitalization not found"));

        HospitalizationAct act = new HospitalizationAct();

        act.setActName(request.getActName());
        act.setAmoCode(request.getAmoCode());
        act.setQuotation(request.getQuotation());
        act.setQuantity(request.getQuantity());
        act.setTotal(
                request.getQuotation() * request.getQuantity()
        );

        hosp.getActs().add(act);

        calculateBilling(hosp);

        return mapToResponse(
                hospitalizationRepository.save(hosp)
        );
    }
}