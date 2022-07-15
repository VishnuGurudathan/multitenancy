package com.example.repository;

import com.example.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vishnu.g
 */
@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
}
