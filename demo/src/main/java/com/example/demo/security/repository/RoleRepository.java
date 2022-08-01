package com.example.demo.security.repository;

import com.example.demo.entities.Roll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roll , Long> {

    @Query("select r from Roll r where r.name = ?1")
    Optional<Roll> findAllByName();
}
