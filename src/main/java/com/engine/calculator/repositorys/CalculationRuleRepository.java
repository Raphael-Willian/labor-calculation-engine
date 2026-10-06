package com.engine.calculator.repositorys;


import com.engine.calculator.models.CalculationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CalculationRuleRepository extends JpaRepository<CalculationRule, UUID> {

    List<CalculationRule> findByTenantOwnerRuleId(UUID idTenant);
}
