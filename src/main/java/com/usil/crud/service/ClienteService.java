package com.usil.crud.service;

import com.usil.crud.dto.ClienteDTO;
import com.usil.crud.entidad.Cliente;

import java.util.Optional;

public interface ClienteService {
    Optional<ClienteDTO> obtenerCliente(Long id);
    Iterable<ClienteDTO> mostrarClientes();
    ClienteDTO agregarCliente(ClienteDTO cliente);
    Optional<ClienteDTO> actualizarCliente (ClienteDTO cliente);
    boolean eliminarCliente(Long id);
}
