package com.engine.calculator.models;

import com.engine.calculator.enums.StatusVersionRule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rule_version")
public class RuleVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idVersionRule;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rule_id", nullable = false, referencedColumnName = "calculation_rule_id")
    private CalculationRule rule;

    @Column(name = "valid_from", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE", updatable = true)
    private LocalDate validFrom; //Válido a partir de...

    @Column(name = "valid_until", updatable = true)
    private LocalDate validUntil; //Válido até...

    @ManyToOne(optional = false)
    @JoinColumn(name = "create_by", nullable = false, updatable = false, referencedColumnName = "user_name")
    private User createdBy;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(name = "status_version_rule",nullable = false, updatable = true)
    private StatusVersionRule statusVersionRule;

}
