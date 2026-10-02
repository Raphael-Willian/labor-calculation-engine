package com.engine.calculator.services;

import com.engine.calculator.dtos.requests.CreateTenantRequest;
import com.engine.calculator.models.Tenant;
import com.engine.calculator.repositorys.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TenantService {

    private TenantRepository tenantRepository;

    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }


    public Tenant create(CreateTenantRequest request){

        Tenant tenant = new Tenant();

        tenant.setNameTenant(request.getName());
        tenant.setStatusActivity(request.getStatus());

        return tenantRepository.save(tenant);

    }

    public Tenant read(UUID idTenant) {

        Tenant findTenant = tenantRepository.findById(idTenant).orElseThrow(() -> new RuntimeException("Tenant com ID: "
        + idTenant + " não foi encontrada."));

        return findTenant;

    }

    public void update(UUID idTenant, Tenant tenantRequest) {

        Tenant findTenant = tenantRepository.findById(idTenant).orElseThrow(() -> new RuntimeException("Tenant com ID: "
                + idTenant + " não foi encontrada."));

        findTenant.setNameTenant(tenantRequest.getNameTenant());
        findTenant.setStatusActivity(tenantRequest.getStatusActivity());

        tenantRepository.save(findTenant);

    }

    public void delete(UUID idTenant) {

        tenantRepository.deleteById(idTenant);

    }

}
