package com.matomaylla.ms_producto.config;

import com.matomaylla.ms_producto.entity.Producto;
import com.matomaylla.ms_producto.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(ProductoRepository productoRepository) {
        return args -> {
            Flux.just(
                    new Producto("Cuenta de Ahorros", "Ahorros 123", new BigDecimal("1000.00"), 1L),
                    new Producto("Tarjeta de Crédito", "Visa Oro", new BigDecimal("500.00"), 2L),
                    new Producto("Cuenta Corriente", "Corriente 456", new BigDecimal("2000.00"), 1L)
            ).flatMap(productoRepository::save).subscribe();
        };
    }
}
