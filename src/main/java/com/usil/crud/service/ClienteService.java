package com.usil.crud.service;

import com.usil.crud.entidad.Cliente;

import java.util.Optional;

public interface ClienteService {
    public Optional<Cliente> findById(Long id);
    public Iterable<Cliente> findAll();
    public Cliente addCliente(Cliente cliente);
    public Cliente updateCliente(Cliente cliente);
    public void deleteCliente(Long id);
}
