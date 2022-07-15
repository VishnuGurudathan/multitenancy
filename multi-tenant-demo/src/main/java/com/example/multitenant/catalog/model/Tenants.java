package com.example.multitenant.catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author vishnu.g
 */
@Getter
@Setter
@Entity
@Table(name = "Tenants")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tenants implements Serializable {

    @Serial
    private static final long serialVersionUID = 5627907070269582544L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tenantId;
    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private boolean initialize;

    @Column(name = "created_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
}
