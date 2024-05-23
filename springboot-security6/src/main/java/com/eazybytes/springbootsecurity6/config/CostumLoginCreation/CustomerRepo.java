package com.eazybytes.springbootsecurity6.config.CostumLoginCreation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {
    Optional<CustomerEntity> findByEmail(String username);
}
