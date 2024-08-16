package com.usil.crud.service.implementacion;

import com.usil.crud.entidad.Cliente;
import com.usil.crud.repository.ClienteRepository;
import com.usil.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImplement implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Optional<Cliente> obtenerCliente(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Iterable<Cliente> mostrarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> actualizarCliente(Cliente cliente) {
        return Optional.ofNullable(cliente)
                .filter(c -> obtenerCliente(c.getId()).isPresent()) // Verificar que el cliente existe
                .map(clienteRepository::save);
    }

    @Override
    public boolean eliminarCliente(Long id) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);

        // Usar ifPresent para eliminar el cliente si existe
        clienteOpt.ifPresent(cliente -> clienteRepository.deleteById(id));

        // Retornar true si el cliente fue encontrado y eliminado, false de lo contrario
        return clienteOpt.isPresent();
    }
}
