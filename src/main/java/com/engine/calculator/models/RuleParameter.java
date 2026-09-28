package com.engine.calculator.models;

import com.engine.calculator.enums.TypeValueInput;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "rule_parameter")
public class RuleParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_parameter_rule", nullable = false, unique = true)
    private UUID idParameterRule;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "rule_version_id", nullable = false)
    private RuleVersion ruleVersionToParameter;

    @Column(name = "parameter_key", nullable = false) // "key" é palavra reservada em vários bancos de dados
    private String key;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_value", nullable = false)
    private TypeValueInput typeOfValue;

    @Column(name = "required", nullable = false)
    private boolean required = true;

}