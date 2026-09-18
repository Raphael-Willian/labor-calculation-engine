package com.engine.calculator.models;

import com.engine.calculator.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", unique = true, nullable = false)
    private UUID idUser;

    @Column(name = "user_name", nullable = false, length = 155)
    private String nameUser;

    @Column(name = "user_email", nullable = false, length = 318, updatable = true)
    private String emailUser;

    @Column(name = "user_password", nullable = false, length = 50, updatable = true)
    private String passwordUser;

    @Column(name = "user_role", nullable = false, updatable = true)
    private UserRole roleUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tenant", nullable = false, referencedColumnName = "tenant_id")
    private Tenant tenant;

}
