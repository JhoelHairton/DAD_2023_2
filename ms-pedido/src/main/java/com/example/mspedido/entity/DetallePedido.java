package com.example.mspedido.entity;

import com.example.mspedido.dto.Cliente;
import com.example.mspedido.dto.Producto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double cantidad;
    private Double precio;
    private Integer productoId;
    @Transient
    private Producto producto;
    public DetallePedido() {
        this.cantidad = (double) 0;
        this.precio = (double) 0;
    }
}
