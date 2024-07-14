package com.matomaylla.ms_cliente.config;

import com.matomaylla.ms_cliente.entity.Cliente;
import com.matomaylla.ms_cliente.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(ClienteRepository clienteRepository) {
        return args -> {
            Flux.just(
                    new Cliente("John", "Doe", "DNI", "12345678"),
                    new Cliente("Jane", "Smith", "DNI", "87654321")
            ).flatMap(clienteRepository::save).subscribe();

        };
    }
}
