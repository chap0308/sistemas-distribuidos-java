package com.example.demo.Pedidos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository <Pedidos, Integer> {

    // Consulta personalizada para buscar pedidos por fecha
    @Query("SELECT so FROM Pedidos so WHERE so.fecha = :fecha")
    List<Pedidos> findPedidoByFecha(@Param("fecha") LocalDate fecha);
}
