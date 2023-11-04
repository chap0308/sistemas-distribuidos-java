package com.example.demo.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Cliente.dto.ClienteInput;
import com.example.demo.Error.LocalNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //*Nos evita colocar el constructor y solo definiendolo es suficiente
public class ClienteService {
    
    @Autowired
    private final ClienteRepository clienteRepository;

    public Cliente createCliente(ClienteInput clienteInput) throws Exception {
        Cliente clienteRegistrado = clienteRepository.findByEmail(clienteInput.getEmail());
        if(clienteRegistrado != null) {
            throw new Exception("El email ya está registrado");
        }
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteInput.getNombre());
        cliente.setApellido(clienteInput.getApellido());
        cliente.setEmail(clienteInput.getEmail());
        cliente.setTelefono(clienteInput.getTelefono());
        return clienteRepository.save(cliente);
        
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Integer id) throws LocalNotFoundException {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if(cliente == null) {
            throw new LocalNotFoundException("No se encontro el cliente");
        }
        return cliente;
    }
    

    public Cliente updateCliente(Integer id, ClienteInput clienteInput) throws Exception {
        
        Cliente clienteActual = this.getClienteById(id);

        Cliente clienteRegistrado = clienteRepository.findByEmail(clienteInput.getEmail());
        if (clienteRegistrado != null && clienteActual.getEmail() != clienteRegistrado.getEmail()) {
            throw new Exception("El email ya está registrado en un cliente");
        }
        clienteActual.setNombre(clienteInput.getNombre());
        clienteActual.setApellido(clienteInput.getApellido());
        clienteActual.setEmail(clienteInput.getEmail());
        clienteActual.setTelefono(clienteInput.getTelefono());
        return clienteRepository.save(clienteActual);
    }

    public boolean deleteCliente(Integer id) throws LocalNotFoundException {
        this.getClienteById(id);
        clienteRepository.deleteById(id);
        return true;
    }

}
