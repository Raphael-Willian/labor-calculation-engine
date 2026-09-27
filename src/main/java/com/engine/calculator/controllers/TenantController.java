package com.engine.calculator.controllers;

import com.engine.calculator.models.Tenant;
import com.engine.calculator.services.TenantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/tenant")
public class TenantController {

    private TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping()
    public ResponseEntity<Tenant> createTenant(@RequestBody Tenant tenantRequest) {

        Tenant tenant = tenantService.create(tenantRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(tenant);

    }

    @GetMapping("/{idTenant}")
    public ResponseEntity<Tenant> readTenant(@RequestParam UUID idTenant) {

        Tenant tenant = tenantService.read(idTenant);

        return ResponseEntity.status(HttpStatus.OK).body(tenant);

    }

    @PutMapping("/{idTenant}")
    public ResponseEntity<Tenant> updateTenant( @RequestParam UUID idTenant, @RequestBody Tenant tenantRequest) {

        tenantService.update(idTenant, tenantRequest);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @DeleteMapping("/{idTenant}")
    public ResponseEntity<Tenant> deleteTenant(@RequestParam UUID idTenant) {

        tenantService.delete(idTenant);

        return ResponseEntity.status(HttpStatus.ACCEPTED);

    }







}
