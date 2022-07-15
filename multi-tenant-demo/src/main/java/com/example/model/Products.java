package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author vishnu.g
 */
@Getter
@Setter
@Entity
@Table(name = "Products")
public class Products implements Serializable {

    @Serial
    private static final long serialVersionUID = 5627907070269582543L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
