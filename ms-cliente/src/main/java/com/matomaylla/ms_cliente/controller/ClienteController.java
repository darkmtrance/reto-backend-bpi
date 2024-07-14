package com.matomaylla.ms_cliente.controller;

import com.matomaylla.ms_cliente.service.ClienteService;
import com.openapi.gen.springboot.api.ClientesApi;
import com.openapi.gen.springboot.model.ClienteProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public class ClienteController implements ClientesApi {

    @Autowired
    private ClienteService clienteService;

    @Override
    public Mono<ResponseEntity<ClienteProductos>> getCliente(String codigo, ServerWebExchange exchange) {
        return clienteService.getClienteByCodigoUnico(codigo)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


}
