package com.example.demo.Pedidos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.DetallePedido.dto.DetallePedidoInput;
// import com.example.demo.DetallePedido.dto.ProductosActualizadosInput;
import com.example.demo.Error.LocalNotFoundException;
import com.example.demo.Pedidos.dto.MultipleDataInput;
// import com.example.demo.Error.LocalNotFoundException;
// import com.example.demo.Pedidos.dto.PedidoInput;

import jakarta.validation.Valid;
// import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class PedidosController {
    @Autowired
    private PedidosService pedidosService;

    @PostMapping("/pedidos")
    public boolean createPedidoConSusDetalles( @Valid @RequestBody MultipleDataInput multipleDataInput) throws Exception {
        return pedidosService.createPedidoConSusDetalles(multipleDataInput);
    }

    @GetMapping("/pedidos")
    public List<Pedidos> getAllPedidos(@RequestParam(name = "fecha") LocalDate fecha) throws Exception {
        return pedidosService.getAllPedidos(fecha);
    }

    @GetMapping("/pedidos/{id}")
    public Pedidos getPedidoById(@PathVariable Integer id) throws LocalNotFoundException {
        return pedidosService.getPedidoById(id);
    }

    // @PutMapping("/pedidos/{id}")
    // public Pedidos updatePedido(@PathVariable Integer id, @Valid @RequestBody PedidoInput pedidoInput) throws Exception {
    //     return pedidosService.updatePedido(id, pedidoInput);
    // }

    // @DeleteMapping("/pedidos/{id}")
    // public boolean deletePedido(@PathVariable Integer id) throws LocalNotFoundException {
    //     return pedidosService.deletePedido(id);
    // }

}
