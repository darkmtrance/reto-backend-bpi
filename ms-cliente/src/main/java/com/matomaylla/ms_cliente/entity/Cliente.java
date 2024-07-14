package com.matomaylla.ms_cliente.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;



@Table("clientes")
@Data
public class Cliente {
    @Id
    private Long id;
    private String nombres;
    private String apellidos;
    @Column("tipodocumento")
    private String tipoDocumento;
    @Column("numerodocumento")
    private String numeroDocumento;

    public Cliente(){}
    public Cliente(String nombres, String apellidos, String tipoDocumento, String numeroDocumento) {

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }
}
