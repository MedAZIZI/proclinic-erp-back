package com.proclinic.erp.settings.staff.service;

import com.proclinic.erp.auth.entity.User;
import com.proclinic.erp.auth.repository.UserRepository;
import com.proclinic.erp.settings.staff.dto.StaffRequest;
import com.proclinic.erp.settings.staff.dto.StaffResponse;
import com.proclinic.erp.settings.staff.entity.Staff;
import com.proclinic.erp.settings.staff.entity.StaffStatus;
import com.proclinic.erp.settings.staff.repository.StaffRepository;
import com.proclinic.erp.settings.staff.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final UserRepository userRepository;

    @Override
    public List<StaffResponse> getAll() {
        return staffRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public StaffResponse getById(Long id) {

        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        return mapToResponse(staff);
    }

    @Override
    public StaffResponse create(StaffRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Staff staff = Staff.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .specialty(request.getSpecialty())
                .status(StaffStatus.valueOf(request.getStatus()))
                .user(user)
                .build();

        return mapToResponse(staffRepository.save(staff));
    }

    @Override
    public StaffResponse update(Long id, StaffRequest request) {

        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        staff.setFirstName(request.getFirstName());
        staff.setLastName(request.getLastName());
        staff.setPhone(request.getPhone());
        staff.setEmail(request.getEmail());
        staff.setSpecialty(request.getSpecialty());
        staff.setStatus(StaffStatus.valueOf(request.getStatus()));

        return mapToResponse(staffRepository.save(staff));
    }

    @Override
    public void delete(Long id) {
        staffRepository.deleteById(id);
    }

    private StaffResponse mapToResponse(Staff staff) {
        return StaffResponse.builder()
                .id(staff.getId())
                .firstName(staff.getFirstName())
                .lastName(staff.getLastName())
                .phone(staff.getPhone())
                .email(staff.getEmail())
                .specialty(staff.getSpecialty())
                .status(staff.getStatus().name())
                .userId(staff.getUser().getId())
                .createdAt(staff.getCreatedAt())
                .build();
    }
}