package com.usil.crud.controller;

import com.usil.crud.dto.ClienteDTO;
import com.usil.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<ClienteDTO>> clientes() {
        Iterable<ClienteDTO> clientes = clienteService.mostrarClientes();
        // Convertir el Iterable a Stream y manejarlo funcionalmente
        return StreamSupport.stream(clientes.spliterator(), false)
                .findAny() // Intenta encontrar cualquier cliente
                .map(_ -> ResponseEntity.ok(clientes))  // Si hay al menos un cliente, devuelve 200 OK
                .orElseGet(() -> ResponseEntity.noContent().build()); // Si no hay clientes, devuelve 204 No Content

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerCliente(@PathVariable Long id) {
        return clienteService.obtenerCliente(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/agregar")
    public ResponseEntity<ClienteDTO> agregarCliente(@RequestBody ClienteDTO cliente) {
        return new ResponseEntity<>(clienteService.agregarCliente(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ClienteDTO> actualizarCliente(@RequestBody ClienteDTO cliente) {
        return clienteService.actualizarCliente(cliente)
                .map(ResponseEntity::ok) // Si hay un cliente, devuelve 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        return clienteService.eliminarCliente(id)
                ? ResponseEntity.noContent().build() // 204 No Content
                : ResponseEntity.notFound().build(); // 404 Not Found
    }
}
