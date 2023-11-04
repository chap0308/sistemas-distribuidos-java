package com.example.demo.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Error.LocalNotFoundException;
import com.example.demo.Producto.dto.ProductoInput;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //*Nos evita colocar el constructor y solo definiendolo es suficiente
public class ProductoService {
    @Autowired
    private final ProductoRepository productoRepository;

    public Producto createProducto(ProductoInput productoInput) {
        Producto producto = new Producto();
        producto.setDescripcion(productoInput.getDescripcion());
        producto.setImagen(productoInput.getImagen());
        producto.setStock(productoInput.getStock());
        producto.setPrecio(productoInput.getPrecio());

        return productoRepository.save(producto);
    }

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Integer id) throws LocalNotFoundException {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto == null) {
            throw new LocalNotFoundException("No se encontro el producto");
        }
        return producto;
    }

    public Producto updateProducto(Integer id, ProductoInput productoInput) throws LocalNotFoundException{
        Producto productoActual = this.getProductoById(id);
        productoActual.setDescripcion(productoInput.getDescripcion());
        productoActual.setImagen(productoInput.getImagen());
        productoActual.setStock(productoInput.getStock());
        productoActual.setPrecio(productoInput.getPrecio());

        return productoRepository.save(productoActual);
    }

    public boolean deleteProducto(Integer id) throws LocalNotFoundException {
        this.getProductoById(id);
        productoRepository.deleteById(id);
        return true;
    }

}
