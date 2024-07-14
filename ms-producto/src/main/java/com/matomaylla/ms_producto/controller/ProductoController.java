package com.matomaylla.ms_producto.controller;


import com.matomaylla.ms_producto.mapper.ProductoMapper;
import com.matomaylla.ms_producto.service.ProductoService;
import com.openapi.gen.springboot.api.ProductosApi;
import com.matomaylla.ms_producto.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductoController implements ProductosApi {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public Mono<ResponseEntity<Flux<com.openapi.gen.springboot.model.Producto>>> getProductosByClienteId(Long clienteId, ServerWebExchange exchange) {
        Flux<Producto> productos = productoService.getProductosByClienteId(clienteId);
        Flux<com.openapi.gen.springboot.model.Producto> mappedProductos = productos.map(productoMapper::toDocument);
        return mappedProductos.hasElements()
                .flatMap(hasElements -> {
                    if (hasElements) {
                        return Mono.just(ResponseEntity.ok(mappedProductos));
                    } else {
                        return Mono.just(ResponseEntity.notFound().build());
                    }
                });
    }
}
