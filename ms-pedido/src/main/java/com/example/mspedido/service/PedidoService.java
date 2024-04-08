package com.example.mspedido.service;

import com.example.mspedido.entity.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> listar();
    Pedido guardar(Pedido categoria);
    Pedido actualizar(Pedido categoria);
    Optional<Pedido> listaPorld(Integer id);
    void eliminar(Integer id);
}
