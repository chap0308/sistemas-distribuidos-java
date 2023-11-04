package com.example.demo.Pedidos.dto;

import com.example.demo.DetallePedido.dto.DetallePedidoInput;
import com.example.demo.DetallePedido.dto.ProductosActualizadosInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultipleDataInput {
    private PedidoInput pedidoInput;
    private DetallePedidoInput detallePedidoInput;
    private ProductosActualizadosInput productosActualizadosInput;

}
