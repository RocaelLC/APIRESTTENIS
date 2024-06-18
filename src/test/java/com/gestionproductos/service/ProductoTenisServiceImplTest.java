package com.gestionproductos.service;

import com.gestiondetenis.model.ProductoTenis;
import com.gestiondetenis.repository.ProductoTenisRepository;
import com.gestiondetenis.service.ProductoTenisServiceImpl;
import com.gestiondetenis.exception.ProductoNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductoTenisServiceImplTest {

    @InjectMocks
    private ProductoTenisServiceImpl productoTenisService;

    @Mock
    private ProductoTenisRepository productoTenisRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getProductoByIdTest() {
        ProductoTenis producto = new ProductoTenis();
        producto.setId("1");
        producto.setNombre("Producto 1");
        producto.setPrecio(100.0);

        when(productoTenisRepository.findById("1")).thenReturn(Optional.of(producto));

        ProductoTenis foundProducto = productoTenisService.getProductoById("1");

        assertNotNull(foundProducto);
        assertEquals("Producto 1", foundProducto.getNombre());
    }

    @Test
    public void getProductoByIdNotFoundTest() {
        when(productoTenisRepository.findById("1")).thenReturn(Optional.empty());

        Exception exception = assertThrows(ProductoNotFoundException.class, () -> {
            productoTenisService.getProductoById("1");
        });

        String expectedMessage = "Producto no encontrado con id: 1";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
