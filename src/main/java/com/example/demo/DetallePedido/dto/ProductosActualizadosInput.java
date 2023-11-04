package com.example.demo.DetallePedido.dto;

import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductosActualizadosInput {
    @NotNull
    // @PositiveOrZero
    private int[] stock;
}
