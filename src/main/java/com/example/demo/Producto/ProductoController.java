package com.example.demo.Producto;

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

import com.example.demo.Error.LocalNotFoundException;
import com.example.demo.Producto.dto.ProductoInput;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/productos")
    public Producto createProducto(@Valid @RequestBody ProductoInput productoInput) {
        return productoService.createProducto(productoInput);
    }

    @GetMapping("/productos")
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/productos/{id}")
    public Producto getProductoById(@PathVariable Integer id) throws LocalNotFoundException {
        return productoService.getProductoById(id);
    }

    @PutMapping("/productos/{id}")
    public Producto updateProducto(@PathVariable Integer id, @Valid @RequestBody ProductoInput productoInput) throws LocalNotFoundException {
        return productoService.updateProducto(id, productoInput);
    }

    @DeleteMapping("/productos/{id}")
    public boolean deleteProducto(@PathVariable Integer id) throws LocalNotFoundException {
        return productoService.deleteProducto(id);
    }
}
