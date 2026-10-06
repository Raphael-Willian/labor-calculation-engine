package com.engine.calculator.controllers;

import com.engine.calculator.dtos.requests.CreateCalculationRuleRequest;
import com.engine.calculator.dtos.responses.CreateCalculationRuleResponse;
import com.engine.calculator.dtos.responses.ReadCalculationResponse;
import com.engine.calculator.models.CalculationRule;
import com.engine.calculator.services.CalculationRuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/calculation")
public class CalculationRuleController {

    private CalculationRuleService calculationRuleService;

    public CalculationRuleController(CalculationRuleService calculationRuleService) {
        this.calculationRuleService = calculationRuleService;
    }

    @PostMapping()
    public ResponseEntity<CreateCalculationRuleResponse> isnert(@RequestBody CreateCalculationRuleRequest request) {

        CreateCalculationRuleResponse calculation = calculationRuleService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(calculation);

    }

    @GetMapping("/{idTenant}")
    public ResponseEntity<ReadCalculationResponse> readCalculations(@RequestParam UUID idTenant) {
        ReadCalculationResponse calculationResponse = calculationRuleService.read(idTenant);

        return ResponseEntity.status(HttpStatus.OK).body(calculationResponse);

    }



}
