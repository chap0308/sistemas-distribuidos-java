package com.example.demo.Producto;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.DetallePedido.DetallePedido;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(length = 50)
    private String descripcion;

    @Column(name = "stock")
    private int stock;

    @Basic
    private String imagen;

    @Column(name = "precio", precision = 10, scale = 2)
    private BigDecimal  precio;

    @OneToMany(mappedBy = "producto")
    @JsonBackReference //* Ignora esta propiedad en la serialización JSON */
    private List<DetallePedido> detallePedido;
}
