package com.matomaylla.ms_producto.mapper;

public interface EntityMapper<D, E> {
    E toDocument(D model);
    D toModel(E domain);
}
