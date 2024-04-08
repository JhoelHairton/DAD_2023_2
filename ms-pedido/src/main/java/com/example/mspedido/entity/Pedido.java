package com.example.mspedido.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    private Date fechaPedido;
    private String cliente;
    private String direccionEntrega;
    private String metodoPago;
    private String estado;
    private double total;
    private String notas;
    private String usuarioResponsable;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallePedido> detalles;
}