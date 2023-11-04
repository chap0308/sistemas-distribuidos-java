package com.example.demo.Producto.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoInput {
    @NotBlank(message = "La descripcion es obligatoria")
    @Size(min = 3, message = "La descripcion debe tener como minimo 3 caracteres")
    private String descripcion;
    @NotNull
    @Min( value = 1, message = "El stock debe ser mayor a 0")
    private Integer stock;
    @NotBlank(message = "La imagen es obligatoria")
    private String imagen;
    @NotNull(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser mayor o igual que 0")
    private BigDecimal precio;
}
