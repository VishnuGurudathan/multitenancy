package com.example.controller;

import com.example.multitenant.catalog.repository.TenantRepository;
import com.example.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vishnu.g
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/common", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class CommonController {

    private final TenantRepository tenantRepository;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(tenantRepository.findAll());
    }
}
