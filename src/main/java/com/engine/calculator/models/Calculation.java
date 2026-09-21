package com.engine.calculator.models;

import com.engine.calculator.dto.request.CalculationInputDTO;
import com.engine.calculator.enums.CalculationStatusProcess;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "calculation")
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "calculation_id", nullable = false, unique = true)
    private UUID idCalculation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant idTenant;

    @OneToOne(mappedBy = "idVersionRule", optional = false)
    @Column(name = "rule_version_id", nullable = false)
    private RuleVersion idRuleuVersion;

    @Column(name = "external_reference", nullable = true, length = 100)
    private String externalReference;

    @Column(name = "inputs", nullable = false)
    private CalculationInputDTO inputs;

    @Column(name = "result", nullable = false, length = 20)
    private BigDecimal result;

    @Column(name = "status_process", nullable = false)
    private CalculationStatusProcess statusProcess;

    @Column(name = "executed_at", updatable = false, nullable = false, columnDefinition = "DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Generated(event = EventType.INSERT)
    private LocalDateTime executedAt = LocalDateTime.now();

}
