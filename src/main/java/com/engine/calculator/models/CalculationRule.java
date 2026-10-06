package com.engine.calculator.models;

import com.engine.calculator.enums.CalculationRuleActivity;
import com.engine.calculator.enums.CalculationType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "calculation_rule")
public class CalculationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "calculation_rule_id", unique = true, nullable = false)
    private UUID idCalculationRule;

    @Column(name = "name_calculation_rule", length = 255, nullable = false)
    private String nameCalculationRule;

    @Column(name = "code_calculation_rule", length = 50)
    private String codeCalculationRule;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_calculation_rule", nullable = false)
    private CalculationType typeCalculationRule;

    @Column(name = "description", length = 455)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_activity_rule", nullable = false)
    private CalculationRuleActivity statusActivityRule;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "rule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RuleVersion> versions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id", nullable = false)
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenantOwnerRule;

}