package com.usil.crud.mapper;

import com.usil.crud.dto.ClienteDTO;
import com.usil.crud.entidad.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper {
    /**
     *
     * @param cliente
     * @return
     */
    ClienteDTO toDTO(Cliente cliente);

    /**
     *
     * @param clienteDTO
     * @return
     */
    Cliente toEntity(ClienteDTO clienteDTO);

    /**
     *
     * @param clientes
     * @return
     */
    Iterable<ClienteDTO> toDtoIterable(Iterable<Cliente> clientes);

    /**
     *
     * @param clienteDTOS
     * @return
     */
    Iterable<Cliente> toEntityIterable(Iterable<ClienteDTO> clienteDTOS);
}
