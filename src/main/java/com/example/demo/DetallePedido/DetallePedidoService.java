package com.example.demo.DetallePedido;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DetallePedido.dto.DetallePedidoInput;
import com.example.demo.DetallePedido.dto.ProductosActualizadosInput;
import com.example.demo.Error.LocalNotFoundException;
import com.example.demo.Pedidos.Pedidos;
import com.example.demo.Pedidos.PedidosRepository;
import com.example.demo.Producto.Producto;
import com.example.demo.Producto.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetallePedidoService {

    @Autowired
    private final DetallePedidoRepository detallePedidoRepository;
    @Autowired
    private final PedidosRepository pedidosRepository;
    @Autowired
    private final ProductoRepository productoRepository;

    public boolean createDetallePedido(Integer pedidoId, DetallePedidoInput detallePedidoInput, ProductosActualizadosInput productosActualizadosInput) throws LocalNotFoundException, Exception {
        try {
            Pedidos pedidoExistente = pedidosRepository.findById(pedidoId).orElse(null);

            if (pedidoExistente == null) {
                throw new LocalNotFoundException("No se encontró el pedido");
            }

            Integer[] productoId = detallePedidoInput.getProductoId();
            int[] cantidad = detallePedidoInput.getCantidad();
            BigDecimal[] precioUnitario = detallePedidoInput.getPrecioUnitario();
            BigDecimal[] precioVenta = detallePedidoInput.getPrecioVenta();
            int[] stock = productosActualizadosInput.getStock();

            for (int i = 0; i < productoId.length; i++) {

                Producto productoExistente = productoRepository.findById(productoId[i]).orElse(null);

                if (productoExistente == null) {
                    throw new LocalNotFoundException("Product with id: " + productoId[i] + " not found");
                }

                DetallePedido newDetailSaleOrder = new DetallePedido();
                newDetailSaleOrder.setProducto(productoExistente);
                newDetailSaleOrder.setPedidos(pedidoExistente);
                newDetailSaleOrder.setCantidad(cantidad[i]);
                newDetailSaleOrder.setPrecioUnitario(precioUnitario[i]);
                newDetailSaleOrder.setPrecioVenta(precioVenta[i]);
                detallePedidoRepository.save(newDetailSaleOrder);

                productoExistente.setStock(stock[i]);
                productoRepository.save(productoExistente);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Ocurrio un error");
        }

    }
}
