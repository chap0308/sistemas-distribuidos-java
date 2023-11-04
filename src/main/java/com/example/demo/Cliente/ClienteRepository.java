package com.example.demo.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer>{
    @Query("SELECT cli FROM Cliente cli WHERE cli.email = :email")
    Cliente findByEmail(@Param("email") String email);
}
