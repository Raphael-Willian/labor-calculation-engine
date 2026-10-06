package com.engine.calculator.services;

import com.engine.calculator.dtos.requests.CreateCalculationRuleRequest;
import com.engine.calculator.dtos.responses.CreateCalculationRuleResponse;
import com.engine.calculator.dtos.responses.ReadCalculationResponse;
import com.engine.calculator.models.CalculationRule;
import com.engine.calculator.repositorys.CalculationRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CalculationRuleService {

    private CalculationRuleRepository calculationRuleRepository;

    public CalculationRuleService(CalculationRuleRepository calculationRuleRepository) {
        this.calculationRuleRepository = calculationRuleRepository;
    }

    public CreateCalculationRuleResponse create(CreateCalculationRuleRequest request) {

        //name, code, type, description, activity
        CalculationRule calculation = new CalculationRule();

        calculation.setNameCalculationRule(request.getName());
        calculation.setCodeCalculationRule(request.getCode());
        calculation.setTypeCalculationRule(request.getType());
        calculation.setDescription(request.getDescription());
        calculation.setStatusActivityRule(request.getActivity());

        calculationRuleRepository.save(calculation);

        return new CreateCalculationRuleResponse(calculation.toString());

    }

    public ReadCalculationResponse read(UUID idTenant){

        List<CalculationRule> calculations = calculationRuleRepository.findByTenantOwnerRuleId(idTenant);

        return new ReadCalculationResponse(calculations);

    }



}
