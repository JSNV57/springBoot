package com.usil.crud.repository;

import com.usil.crud.entidad.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente,Long> {
}
