package com.engine.calculator.models;

import com.engine.calculator.enums.TenantActivityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tenant")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tenant_id", unique = true, nullable = false)
    private UUID idTenant;

    @Column(name = "name_tenant", length = 255, nullable = false)
    private String nameTenant;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "status_activity")
    private TenantActivityStatus statusActivity;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.REMOVE)
    private List<User> users;

}