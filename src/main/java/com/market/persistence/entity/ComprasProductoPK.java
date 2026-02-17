package com.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;


@Embeddable // Esta clase puede "incrustarse" dentro de una entidad
public class ComprasProductoPK implements Serializable {

    @Column(name = "id_compra")
    private Integer idCompra; // Parte 1 de la clave primaria compuesta

    @Column(name = "id_producto")
    private Integer idProducto; // Parte 2 de la clave primaria compuesta


    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
