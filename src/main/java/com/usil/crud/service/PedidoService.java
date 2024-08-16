package com.usil.crud.service;

import com.usil.crud.entidad.Cliente;
import com.usil.crud.entidad.Pedido;

public interface PedidoService {
    public Pedido findById(Long id);
    public Iterable<Pedido> findAll();
    public void save(Pedido pedido);
}
