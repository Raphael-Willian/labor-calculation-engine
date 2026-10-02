package com.engine.calculator.dtos.requests;

import com.engine.calculator.enums.UserRole;
import com.engine.calculator.models.Tenant;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateUserRequest {

    String name;
    String email;
    String password;
    UserRole role;
    Tenant tenant;

}
