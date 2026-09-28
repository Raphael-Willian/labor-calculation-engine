package com.engine.calculator.models;

import com.engine.calculator.enums.StatusVersionRule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "rule_version")
public class RuleVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "version_rule_id", nullable = false, updatable = false, unique = true)
    private UUID idVersionRule;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "calculation_rule_id", nullable = false)
    private CalculationRule rule;

    @Column(name = "valid_from", nullable = false)
    private LocalDate validFrom;

    @Column(name = "valid_until")
    private LocalDate validUntil;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id", nullable = false)
    private User createdBy;

    @OneToMany(mappedBy = "ruleVersionToParameter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RuleParameter> parameters;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "status_version_rule", nullable = false)
    private StatusVersionRule statusVersionRule;

}