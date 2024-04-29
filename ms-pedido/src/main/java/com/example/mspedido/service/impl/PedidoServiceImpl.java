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

        Optional<Pedido> pedido = pedidosRepository.findById(id);
        Cliente clienteDto = clienteFeign.listaPorld(pedido.get().getCliente().getId()).getBody();
       /* for (PedidoDetalle pedidoDetalle : pedido.get().getDetalle()) {
            pedidoDetalle.setProductoDto(catalogoFeign.productoBuscarPorId(pedidoDetalle.getProductoId()).getBody());
        }*/

        List<DetallePedido> pedidoDetalles = pedido.get().getDetalles().stream().map(pedidoDetalle -> {
            pedidoDetalle.setProducto(productoFeign.listaPorld(pedidoDetalle.getProducto().getId()).getBody());
            return pedidoDetalle;
        }).toList();
        pedido.get().setCliente(clienteDto);
        pedido.get().setDetalles(pedidoDetalles);
        return pedidosRepository.findById(id);
    }


    @Override
    public void eliminar(Integer id) {
        pedidosRepository.deleteById(id);
    }
}
