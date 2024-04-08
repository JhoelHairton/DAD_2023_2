package com.example.mspedido.controller;


import com.example.mspedido.entity.Pedido;
import com.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping()
    public ResponseEntity<List<Pedido>> listar(){
        return ResponseEntity.ok(pedidoService.listar());
    }

    @PostMapping
    public ResponseEntity<Pedido>guardar(@RequestBody Pedido pedido){
        return ResponseEntity.ok(pedidoService.guardar(pedido));
    }

    @PutMapping
    public ResponseEntity<Pedido>actualizar(@RequestBody Pedido pedido){
        return ResponseEntity.ok(pedidoService.actualizar(pedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido>listaPorld(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(pedidoService.listaPorld(id).get());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<List<Pedido>>eliminar(@PathVariable(required = true) Integer id){
        pedidoService.eliminar(id);
        return ResponseEntity.ok(pedidoService.listar());
    }
}
