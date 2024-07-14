package com.matomaylla.ms_producto.mapper;

import com.matomaylla.ms_producto.entity.Producto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper implements EntityMapper<Producto, com.openapi.gen.springboot.model.Producto>{

    @Override
    public com.openapi.gen.springboot.model.Producto toDocument(Producto model) {
        com.openapi.gen.springboot.model.Producto producto = new com.openapi.gen.springboot.model.Producto();
        BeanUtils.copyProperties(model, producto);
        if (model.getSaldo() != null) {
            producto.setSaldo(model.getSaldo().doubleValue());
        }

        return producto;
    }

    @Override
    public Producto toModel(com.openapi.gen.springboot.model.Producto domain) {
        Producto producto = new Producto();
        BeanUtils.copyProperties(domain, producto);
        return producto;
    }
}
