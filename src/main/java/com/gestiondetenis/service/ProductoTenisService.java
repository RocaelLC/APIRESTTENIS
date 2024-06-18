package com.gestiondetenis.service;

import com.gestiondetenis.model.ProductoTenis;

import java.util.List;

public interface ProductoTenisService {
    List<ProductoTenis> getAllProductos();
    ProductoTenis getProductoById(String id);
    ProductoTenis createProducto(ProductoTenis productoTenis);
    ProductoTenis updateProducto(String id, ProductoTenis productoTenis);
    void deleteProducto(String id);
}
