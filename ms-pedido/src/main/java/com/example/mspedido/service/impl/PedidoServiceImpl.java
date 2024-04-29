package com.example.mspedido.service.impl;

import com.example.mspedido.entity.Pedido;
import com.example.mspedido.feign.ClienteFeign;
import com.example.mspedido.feign.ProductoFeign;
import com.example.mspedido.repository.PedidosRepository;
import com.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ClienteFeign clienteFeign;

    @Autowired
    private ProductoFeign productoFeign;


    @Override
    public List<Pedido> listar() {
        return pedidosRepository.findAll();
    }
    @Override
    public Pedido guardar(Pedido pedido) {
        return pedidosRepository.save(pedido);
    }

    @Override
    public Pedido actualizar(Pedido pedido) {
        return pedidosRepository.save(pedido);
    }

    @Override
    public Optional<Pedido> listaPorld(Integer id) {
        return pedidosRepository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        pedidosRepository.deleteById(id);
    }
}
