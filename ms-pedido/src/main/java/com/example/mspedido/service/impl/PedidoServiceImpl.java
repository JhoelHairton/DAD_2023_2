package com.example.mspedido.service.impl;

import com.example.mspedido.dto.Cliente;
import com.example.mspedido.dto.Producto;
import com.example.mspedido.entity.DetallePedido;
import com.example.mspedido.entity.Pedido;
import com.example.mspedido.feign.ClienteFeign;
import com.example.mspedido.feign.ProductoFeign;
import com.example.mspedido.repository.PedidosRepository;
import com.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        Pedido pedido = pedidosRepository.findById(id).get();
        Cliente cliente = clienteFeign.listaPorld(pedido.getClienteId()).getBody();
        System.out.println(cliente.toString());
        List<DetallePedido> Detallespedido = pedido.getDetalle().stream().map(pedidoDetalle -> {
            Producto producto = productoFeign.listaPorld(pedidoDetalle.getProductoId()).getBody();
            pedidoDetalle.setProducto(producto);
            return pedidoDetalle;
        }).collect(Collectors.toList());
        pedido.setDetalle(Detallespedido);
        pedido.setCliente(cliente);
        return Optional.of(pedido);
    }


    @Override
    public void eliminar(Integer id) {
        pedidosRepository.deleteById(id);
    }
}
