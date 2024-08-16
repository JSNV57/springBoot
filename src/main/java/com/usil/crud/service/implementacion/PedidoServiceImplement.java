package com.usil.crud.service.implementacion;

import com.usil.crud.entidad.Pedido;
import com.usil.crud.repository.PedidoRepository;
import com.usil.crud.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImplement implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).get();
    }

    @Override
    public Iterable<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public void save(Pedido pedido) {
        pedidoRepository.save(pedido);
    }
}
