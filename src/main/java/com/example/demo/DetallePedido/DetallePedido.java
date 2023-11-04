package com.example.demo.DetallePedido;

import java.math.BigDecimal;

import com.example.demo.Pedidos.Pedidos;
import com.example.demo.Producto.Producto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false) //* El EAGER nos permite que se vean los datos completos de esta propiedad */
    @JoinColumn(name = "producto_id", nullable = false)
    @JsonIgnoreProperties("detallePedido") //* Excluye la propiedad "detallePedido" de la serialización */
    private Producto producto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido_id", nullable = false)
    @JsonBackReference //* Ignora esta propiedad en la serialización JSON */
    private Pedidos pedidos;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario", precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precioVenta;
}
