package com.engine.calculator.models;


import com.engine.calculator.enums.TenantActivityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tenant")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tenant_id", unique = true, nullable = false)
    private UUID idTenant;

    @Column(name = "name_tenant", length = 255, nullable = false)
    private String nameTenant;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "status_activity")
    private TenantActivityStatus statusActivity;

    @OneToMany(mappedBy = "idUser", cascade = CascadeType.REMOVE)
    @Column(name = "id_user")
    private User user;

}
