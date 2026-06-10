package com.proclinic.erp.settings.staff.entity;

import com.proclinic.erp.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    private String phone;
    private String email;

    private String specialty;

    @Enumerated(EnumType.STRING)
    private StaffStatus status;

    private LocalDateTime createdAt;

    // 🔗 relation avec User
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}