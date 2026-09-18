package com.engine.calculator.models;

import com.engine.calculator.enums.CalculationRuleActivity;
import com.engine.calculator.enums.CalculationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CalculationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "calculation_rule_id", unique = true, nullable = false)
    private UUID idCalculationRule;

    @Column(name = "name_calculation_rule", length = 255, updatable = true, nullable = false)
    private String nameCalculationRule;

    //Este atributo consiste em um nome "identificador" definido pelo usuário. Como se o usuário pudesse ter uma família de calculos
    @Column(name = "code_calculation_rule", length = 50, updatable = true)
    private String codeCalculationRule;

    @Column(name = "type_calculation_rule", nullable = false, updatable = true)
    private CalculationType typeCalculationRule;

    @Column(name = "description", length = 455, updatable = true)
    private String description;

    @Column(name = "status_activity_rule", nullable = false, updatable = true)
    private CalculationRuleActivity statusActivityRule;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime  createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false, referencedColumnName = "user_name")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "tenant_owner_rule", nullable = false, referencedColumnName = "tenant_id")
    private Tenant tenantOwnerRule;

}
