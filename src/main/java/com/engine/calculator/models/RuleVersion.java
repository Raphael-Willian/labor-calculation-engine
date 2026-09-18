package com.engine.calculator.models;

import com.engine.calculator.enums.StatusVersionRule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rule_version")
public class RuleVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "version_rule_id", nullable = false, updatable = false, unique = true)
    private UUID idVersionRule;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rule_id", nullable = false, referencedColumnName = "calculation_rule_id")
    private CalculationRule rule;

    @Column(name = "valid_from", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE", updatable = true)
    @Generated(event = EventType.INSERT)
    private LocalDate validFrom; //Válido a partir de...

    @Column(name = "valid_until", updatable = true)
    private LocalDate validUntil; //Válido até...

    @ManyToOne(optional = false)
    @JoinColumn(name = "create_by", nullable = false, updatable = false, referencedColumnName = "user_name")
    private User createdBy;

    @OneToMany(mappedBy = "idParameterRule", cascade = CascadeType.REMOVE)
    @Column(name = "parameters", nullable = false, updatable = true)
    private List<RuleParameter> parameters;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(name = "status_version_rule",nullable = false, updatable = true)
    private StatusVersionRule statusVersionRule;

}
