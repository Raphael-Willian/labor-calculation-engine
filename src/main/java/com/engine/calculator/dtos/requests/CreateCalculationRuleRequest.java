package com.engine.calculator.dtos.requests;

import com.engine.calculator.enums.CalculationRuleActivity;
import com.engine.calculator.enums.CalculationType;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class CreateCalculationRuleRequest {

    String name;
    String code;
    CalculationType type;
    String description;
    CalculationRuleActivity activity;

}
