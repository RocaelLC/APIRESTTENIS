package com.gestionproductos.controller;

import com.gestiondetenis.controller.ProductoTenisController;
import com.gestiondetenis.model.ProductoTenis;
import com.gestiondetenis.service.ProductoTenisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductoTenisController.class)
public class ProductoTenisControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoTenisService productoTenisService;

    @Test
    public void getAllProductosTest() throws Exception {
        ProductoTenis producto1 = new ProductoTenis();
        producto1.setId("1");
        producto1.setNombre("Producto 1");
        producto1.setPrecio(100.0);

        ProductoTenis producto2 = new ProductoTenis();
        producto2.setId("2");
        producto2.setNombre("Producto 2");
        producto2.setPrecio(200.0);

        given(productoTenisService.getAllProductos()).willReturn(Arrays.asList(producto1, producto2));

        mockMvc.perform(get("/api/productos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre").value("Producto 1"))
                .andExpect(jsonPath("$[1].nombre").value("Producto 2"));
    }
}
