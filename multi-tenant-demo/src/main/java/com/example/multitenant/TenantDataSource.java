package com.example.multitenant;

import com.example.constants.Constants;
import com.example.multitenant.catalog.model.Tenants;
import com.example.multitenant.catalog.repository.TenantRepository;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author vishnu.g
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TenantDataSource {

    @Qualifier("catalogDataSourceProperties")
    private final DataSourceProperties dataSourceProperties;
    private final TenantRepository tenantRepository;

    public DataSource findByTenantId(String tenantId) {
        Tenants tenant = tenantRepository.findByTenantId(tenantId)
                .orElseThrow(() -> new RuntimeException("No such tenant: " + tenantId));
        return createAndConfigureDataSource(tenant);
    }

    private DataSource createAndConfigureDataSource(Tenants tenant) {
        HikariDataSource dataSource = dataSourceProperties
                .initializeDataSourceBuilder().type(HikariDataSource.class).build();

        dataSource.setUsername(tenant.getUsername());
        dataSource.setPassword(tenant.getPassword());
        dataSource.setJdbcUrl(tenant.getUrl());
        dataSource.setDriverClassName(tenant.getDriverClassName());

        //ds.setDataSource();

        dataSource.setPoolName(Constants.TENANT_POOL_NAME_PREFIX + tenant.getTenantId());

        log.debug("Configured datasource connection pool: {}", dataSource.getPoolName());
        return dataSource;
    }
}
