package com.example.mspedido.feign;

import com.example.mspedido.dto.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ClienteFeign {
    @FeignClient(name= "ms-catalogo-service", path = "/cliente")
    public interface ProductoFeign {

        @GetMapping("/{id}")
        public ResponseEntity<Producto> listaPorld(@PathVariable(required = true) Integer id);
    }

}
