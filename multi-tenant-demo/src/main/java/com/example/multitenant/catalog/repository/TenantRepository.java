package com.example.multitenant.catalog.repository;

import com.example.multitenant.catalog.model.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author vishnu.g
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenants, Long> {
    @Query("select t from Tenants t where t.tenantId = :tenantId")
    Optional<Tenants> findByTenantId(@Param("tenantId") String tenantId);
}
