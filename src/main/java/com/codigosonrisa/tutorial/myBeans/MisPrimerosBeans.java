package com.codigosonrisa.tutorial.myBeans;

import com.codigosonrisa.tutorial.models.Producto;
import com.codigosonrisa.tutorial.services.IOrderService;
import com.codigosonrisa.tutorial.services.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class  MisPrimerosBeans {
    @Bean
    public MiBean crearMiBean() {
        return new MiBean();
    }

    @Bean
    public IOrderService instanciarOrderService() {
        boolean esProduccion = true;

        if (esProduccion) {
            return new OrderService();
        } {
            return new IOrderService() {
            @Override
            public void saveOrder(List<Producto> productos) {
                System.out.println("Guardando en la base de datos Local");
                }

            };
        }
    }
}
