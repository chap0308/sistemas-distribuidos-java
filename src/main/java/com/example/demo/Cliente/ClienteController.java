package com.example.demo.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Cliente.dto.ClienteInput;
import com.example.demo.Error.LocalNotFoundException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/clientes")
    public Cliente createCliente(@Valid @RequestBody ClienteInput clienteInput) throws Exception {
        return clienteService.createCliente(clienteInput);
    }

    @GetMapping("/clientes")
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/clientes/{id}")
    public Cliente getClienteById(@PathVariable Integer id) throws LocalNotFoundException {
        return clienteService.getClienteById(id);
    }

    @PutMapping("/clientes/{id}")
    public Cliente updateCliente(@PathVariable Integer id, @Valid @RequestBody ClienteInput clienteInput) throws Exception {
        return clienteService.updateCliente(id, clienteInput);
    }

    @DeleteMapping("/clientes/{id}")
    public void deleteCliente(@PathVariable Integer id) throws LocalNotFoundException {
        clienteService.deleteCliente(id);
    }

}
