package com.matomaylla.ms_cliente.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ProductoClient {

    private final WebClient webClient;

    @Autowired
    public ProductoClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<com.openapi.gen.springboot.model.Producto> getProductos(Long clienteId) {
        return webClient.get()
                .uri("/productos/{clienteId}", clienteId)
                .retrieve()
                .bodyToFlux(com.openapi.gen.springboot.model.Producto.class);
    }
}
