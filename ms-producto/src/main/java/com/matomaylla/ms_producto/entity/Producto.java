package com.matomaylla.ms_producto.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;

@Table("productos")
@Data
public class Producto {
    @Id
    private Long id;
    @Column("tipoproducto")
    private String tipoProducto;
    @Column("nombreproducto")
    private String nombreProducto;
    private BigDecimal saldo;
    @Column("clienteid")
    private Long clienteId;

    public Producto(){

    }

    public Producto(String tipoProducto, String nombreProducto, BigDecimal saldo, Long clienteId) {
        this.tipoProducto = tipoProducto;
        this.nombreProducto = nombreProducto;
        this.saldo = saldo;
        this.clienteId = clienteId;
    }
}
