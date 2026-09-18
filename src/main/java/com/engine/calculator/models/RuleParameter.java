package com.engine.calculator.models;

import com.engine.calculator.enums.TypeValueInput;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rule_parameter")
public class RuleParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_parameter_rule", nullable = false, unique = true)
    private UUID idParameterRule;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rule_version_to_parameter", nullable = false, referencedColumnName = "version_rule_id")
    private RuleVersion ruleVersionToParameter;

    @Column(name = "key", nullable = false)
    private String key; //Nome técnico do parâmetro

    @Column(name = "type_of_value", nullable = false, updatable = true)
    private TypeValueInput typeOfValue;

    @Column(name = "required", nullable = false, updatable = true, columnDefinition = "BOOLEAN DEFAULT TRUE")
    @Generated(event = EventType.INSERT)
    private boolean required;


}
