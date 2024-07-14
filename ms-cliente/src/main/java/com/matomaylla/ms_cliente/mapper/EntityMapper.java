package com.matomaylla.ms_cliente.mapper;

public interface EntityMapper<D, E> {
    E toDocument(D model);
    D toModel(E domain);
}
