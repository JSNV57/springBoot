package com.usil.crud.service;

import com.usil.crud.entidad.Pedido;

import java.util.Optional;

public interface PedidoService {
    Optional<Pedido> obtenerPedido(Long id);
    Iterable<Pedido> mostrarPedidos();
    Pedido agregarPedido(Pedido pedido);
    Optional<Pedido>  actualizarPedido(Pedido pedido);
    boolean eliminarPedido(Long id);
}
