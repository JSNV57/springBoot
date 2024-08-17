package com.usil.crud.service.implementacion;

import com.usil.crud.dto.ClienteDTO;
import com.usil.crud.entidad.Cliente;
import com.usil.crud.mapper.ClienteMapper;
import com.usil.crud.repository.ClienteRepository;
import com.usil.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImplement implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Autowired
    public ClienteServiceImplement(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public Optional<ClienteDTO> obtenerCliente(Long id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::toDTO);
    }

    @Override
    public Iterable<ClienteDTO> mostrarClientes() {
        return clienteMapper.toDtoIterable(clienteRepository.findAll());
    }

    @Override
    public ClienteDTO agregarCliente(ClienteDTO clienteDTO) {
        return clienteMapper.toDTO(clienteRepository.save(clienteMapper.toEntity(clienteDTO)));
    }

    @Override
    public Optional<ClienteDTO> actualizarCliente(ClienteDTO clienteDTO) {
        return Optional.ofNullable(clienteDTO)
                .filter(c -> obtenerCliente(c.getId()).isPresent()) // Verificar que el cliente existe
                .map(clienteDTO1 -> clienteMapper.toDTO(clienteRepository.save(clienteMapper.toEntity(clienteDTO1))));
    }

    @Override
    public boolean eliminarCliente(Long id) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);

        // Usar ifPresent para eliminar el cliente si existe
        clienteOpt.ifPresent(_ -> clienteRepository.deleteById(id));

        // Retornar true si el cliente fue encontrado y eliminado, false de lo contrario
        return clienteOpt.isPresent();
    }
}
