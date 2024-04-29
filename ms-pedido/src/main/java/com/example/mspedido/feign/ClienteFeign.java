package com.example.mspedido.feign;

import com.example.mspedido.dto.Cliente;
import com.example.mspedido.dto.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "ms-catalogo-cliente", path = "/cliente")

public interface ClienteFeign {
        @GetMapping("/{id}")
        public ResponseEntity<Cliente>listaPorld(@PathVariable(required = true) Integer id);

}
