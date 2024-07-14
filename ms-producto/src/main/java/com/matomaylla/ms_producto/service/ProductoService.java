package com.matomaylla.ms_producto.service;

import com.matomaylla.ms_producto.entity.Producto;
import com.matomaylla.ms_producto.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Flux<Producto> getProductosByClienteId(Long clienteId){
        log.debug("Busqueda de productos del clienteId {}", clienteId);
        return productoRepository.findByClienteId(clienteId);
    }

}
