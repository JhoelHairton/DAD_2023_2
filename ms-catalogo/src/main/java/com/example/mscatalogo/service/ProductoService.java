package com.example.mscatalogo.service;

import com.example.mscatalogo.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    public List<Producto> listar();

    public Producto guardar(Producto producto);

    public Optional<Producto> listaPorld(Integer id);

    public Producto editar(Producto producto);

    public void eliminar(Integer id);

}
