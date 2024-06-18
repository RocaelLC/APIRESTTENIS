package com.gestiondetenis.service;

import com.gestiondetenis.model.ProductoTenis;
import com.gestiondetenis.repository.ProductoTenisRepository;
import com.gestiondetenis.exception.ProductoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoTenisServiceImpl implements ProductoTenisService {

    @Autowired
    private ProductoTenisRepository productoTenisRepository;

    @Override
    public List<ProductoTenis> getAllProductos() {
        return productoTenisRepository.findAll();
    }

    @Override
    public ProductoTenis getProductoById(String id) {
        return productoTenisRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado con id: " + id));
    }
    

    @Override
    public ProductoTenis createProducto(ProductoTenis productoTenis) {
        return productoTenisRepository.save(productoTenis);
    }

    @Override
    public ProductoTenis updateProducto(String id, ProductoTenis productoTenis) {
        ProductoTenis existingProducto = getProductoById(id);
        existingProducto.setNombre(productoTenis.getNombre());
        existingProducto.setPrecio(productoTenis.getPrecio());
        return productoTenisRepository.save(existingProducto);
    }

    @Override
    public void deleteProducto(String id) {
        productoTenisRepository.deleteById(id);
    }

    
}
