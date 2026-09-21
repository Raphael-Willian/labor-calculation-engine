package com.engine.calculator.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CalculationInputDTO {

    private BigDecimal salary;

    private BigDecimal hourlyRate;

    private BigDecimal workedHours;

    private BigDecimal overtimeHours;

    private LocalDate admissionDate;

    private LocalDate terminationDate;

    private LocalDate referenceDate;

    private Integer monthsWorked;

    private BigDecimal commissions;

    private BigDecimal bonuses;

    private Integer workingDays;

    private Integer restDays;

    private Integer holidays;

    private BigDecimal remuneration;
}
