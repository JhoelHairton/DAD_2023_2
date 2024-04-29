package com.example.mspedido.entity;

import com.example.mspedido.dto.Cliente;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalle;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    @Transient
    private Cliente producto;
}
