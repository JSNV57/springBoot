package com.usil.crud.service;

import com.usil.crud.entidad.Cliente;

import java.util.Optional;

public interface ClienteService {
    Optional<Cliente> obtenerCliente(Long id);
    Iterable<Cliente> mostrarClientes();
    Cliente agregarCliente(Cliente cliente);
    Optional<Cliente> actualizarCliente (Cliente cliente);
    boolean eliminarCliente(Long id);
}
