package com.example.demo.Pedidos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Cliente.Cliente;
import com.example.demo.Cliente.ClienteRepository;
import com.example.demo.DetallePedido.DetallePedidoService;
// import com.example.demo.DetallePedido.dto.DetallePedidoInput;
// import com.example.demo.DetallePedido.dto.ProductosActualizadosInput;
import com.example.demo.Error.LocalNotFoundException;
import com.example.demo.Pedidos.dto.MultipleDataInput;
import com.example.demo.Pedidos.dto.PedidoInput;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidosService {

    @Autowired
    private final PedidosRepository pedidosRepository;
    @Autowired
    private final ClienteRepository clienteRepository;
    @Autowired
    private final DetallePedidoService detallePedidoService;

    public Integer createPedido( PedidoInput pedidoInput) throws LocalNotFoundException, Exception {
        // System.out.println(pedidoInput);
        try {
            Cliente cliente =clienteRepository.findById(pedidoInput.getClienteId()).orElse(null);
            if(cliente == null) {
                throw new LocalNotFoundException("No se encontro el cliente");
            }
            Pedidos newPedido = new Pedidos();
            newPedido.setCliente(cliente);
            newPedido.setFecha(pedidoInput.getFecha());
            newPedido.setPrecioTotal(pedidoInput.getPrecioTotal());
            // System.out.println(newPedido);
            pedidosRepository.save(newPedido);
            return newPedido.getId();
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Ocurrió un problema");
        }
    }
    
    public boolean createPedidoConSusDetalles(MultipleDataInput multipleDataInput) throws LocalNotFoundException, Exception{
        System.out.println(multipleDataInput.getPedidoInput());
        Integer pedidoId = this.createPedido(multipleDataInput.getPedidoInput());

        return detallePedidoService.createDetallePedido(pedidoId, multipleDataInput.getDetallePedidoInput(), multipleDataInput.getProductosActualizadosInput());
    }

	public List<Pedidos> getAllPedidos( LocalDate fecha) throws Exception{
        // System.out.println(fecha);
        if(fecha == null){
            throw new Exception("Falta la fecha");
        }
        try {

            return pedidosRepository.findPedidoByFecha(fecha);
            // return null;
        } catch (Exception e) {
            throw new Exception("Ocurrio un error");
        }
	}

	public Pedidos getPedidoById(Integer id) throws LocalNotFoundException{
        Pedidos pedido = pedidosRepository.findById(id).orElse(null);
        if(pedido == null){
            throw new LocalNotFoundException("No se encontro el pedido");
        }
        return pedido;
	}

	// public Pedidos updatePedido(Integer id, PedidoInput pedidoInput) throws Exception{
	// 	return null;
	// }

	// public boolean deletePedido(Integer id) throws LocalNotFoundException {
	// 	return false;
	// }
    
}
