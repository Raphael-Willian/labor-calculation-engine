package com.engine.calculator.models;

import com.engine.calculator.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", unique = true, nullable = false)
    private UUID idUser;

    @Column(name = "user_name", nullable = false, length = 155)
    private String nameUser;

    @Column(name = "user_email", nullable = false, length = 318)
    private String emailUser;

    @Column(name = "user_password", nullable = false, length = 255)
    private String passwordUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole roleUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

}