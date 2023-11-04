package com.example.demo.Pedidos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoInput {
    @NotNull(message = "El id del cliente es obligatorio")
    private Integer clienteId;
    @NotNull(message = "La fecha es obligatorio")
    private LocalDate fecha;
    @NotNull(message = "El precio total es obligatorio")
    @Min(value = 1, message = "El precio total debe ser mayor a 0")
    private BigDecimal precioTotal;
    
}
