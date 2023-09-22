package com.codigosonrisa.tutorial.services;

import com.codigosonrisa.tutorial.models.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class OrderService implements IOrderService {

    @Value("${misurls.database}")
    private String databaseUrl;

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);
    public void saveOrder(List<Producto> productos) {
        System.out.println("Guardando en la base de datos la url es: " + databaseUrl);
        productos.forEach(producto -> {
            logger.debug("Producto {} precio {}", producto.nombre, producto.precio);
        });
    }
}
