package com.engine.calculator.dtos.requests;

import com.engine.calculator.enums.TenantActivityStatus;
import lombok.Getter;

@Getter
public class CreateTenantRequest {

    String name;
    TenantActivityStatus status;

}
