package com.example.demo.Pedidos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.Cliente.Cliente;
import com.example.demo.DetallePedido.DetallePedido;
// import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonIgnoreProperties("pedidos")
    private Cliente cliente;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name= "precio_total", precision = 10, scale = 2)
    private BigDecimal precioTotal;

    @OneToMany(mappedBy = "pedidos", fetch = FetchType.EAGER)
    private List<DetallePedido> detallePedido;
}
