package com.matomaylla.ms_cliente.mapper;

import com.matomaylla.ms_cliente.entity.Cliente;
import org.springframework.beans.BeanUtils;

public class ClienteMapper implements EntityMapper<Cliente, com.openapi.gen.springboot.model.Cliente>{
    @Override
    public com.openapi.gen.springboot.model.Cliente toDocument(Cliente model) {
        com.openapi.gen.springboot.model.Cliente cliente = new com.openapi.gen.springboot.model.Cliente();
        BeanUtils.copyProperties(model, cliente);
        return cliente;
    }

    @Override
    public Cliente toModel(com.openapi.gen.springboot.model.Cliente domain) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(domain, cliente);
        return cliente;
    }
}
