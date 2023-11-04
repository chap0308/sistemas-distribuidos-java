package com.example.demo.DetallePedido.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoInput {
    @NotEmpty(message = "los productos son obligarios")
    private Integer[] productoId;

    @NotNull(message = "la cantidad es obligatoria")
    private int[] cantidad;

    @PositiveOrZero
    private BigDecimal[] precioUnitario;

    @PositiveOrZero
    private BigDecimal[] precioVenta;
}
