package com.usil.crud.controller;
import com.usil.crud.entidad.Cliente;
import com.usil.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Cliente>> clientes(){
        Iterable<Cliente> clientes=clienteService.findAll();
        if (!clientes.iterator().hasNext())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(clienteService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> obtenerCliente(@PathVariable Long id){
        Optional<Cliente> cliente=clienteService.findById(id);
        if (!cliente.isPresent())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cliente);
    }
    @PostMapping("/agregar")
    public ResponseEntity  agregarCliente(@RequestBody Cliente cliente){
        Cliente cliente1=clienteService.addCliente(cliente);
        return new ResponseEntity<>(cliente1, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity  actualizarCliente(@RequestBody Cliente cliente){
        Cliente cliente1=clienteService.updateCliente(cliente);
        return new ResponseEntity<>(cliente1, HttpStatus.CREATED);
    }

}
