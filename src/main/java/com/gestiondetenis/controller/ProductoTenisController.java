package com.gestiondetenis.controller;

import com.gestiondetenis.model.ProductoTenis;
import com.gestiondetenis.service.ProductoTenisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoTenisController {

    @Autowired
    private ProductoTenisService productoTenisService;

    @GetMapping
    public List<ProductoTenis> getAllProductos() {
        return productoTenisService.getAllProductos();
    }

    @GetMapping("/{id}")
    public ProductoTenis getProductoById(@PathVariable String id) {
        return productoTenisService.getProductoById(id);
    }

    @PostMapping
    public ProductoTenis createProducto(@RequestBody ProductoTenis productoTenis) {
        return productoTenisService.createProducto(productoTenis);
    }

    @PutMapping("/{id}")
    public ProductoTenis updateProducto(@PathVariable String id, @RequestBody ProductoTenis productoTenis) {
        return productoTenisService.updateProducto(id, productoTenis);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable String id) {
        productoTenisService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }
}
