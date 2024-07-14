package com.matomaylla.ms_producto.repository;

import com.matomaylla.ms_producto.entity.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProductoRepository extends ReactiveCrudRepository<Producto, Long> {
    Flux<Producto> findByClienteId(Long clienteId);
}
