package com.usil.crud.service.implementacion;

import com.usil.crud.entidad.Pedido;
import com.usil.crud.repository.PedidoRepository;
import com.usil.crud.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoServiceImplement implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Optional<Pedido> obtenerPedido(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Iterable<Pedido> mostrarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido agregarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Optional<Pedido>  actualizarPedido(Pedido pedido) {
        return Optional.ofNullable(pedido)
                .filter(_ -> obtenerPedido(pedido.getId()).isPresent()) // Verificar que el pedido exista
                .map(pedidoRepository::save);
    }

    @Override
    public boolean eliminarPedido(Long id) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(id);
        //Elimina solo si existe pedido
        pedidoOpt.ifPresent(_ -> pedidoRepository.deleteById(id));
        // Retornar true si el pedido fue encontrado y eliminado, false de lo contrario
        return pedidoOpt.isPresent();
    }
}
