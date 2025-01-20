package com.bancojavar.demo_bancojavar_api.controller;

import com.bancojavar.demo_bancojavar_api.dto.ClienteCreateDTO;
import com.bancojavar.demo_bancojavar_api.dto.ClienteListDTO;
import com.bancojavar.demo_bancojavar_api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteListDTO> createCliente(@RequestBody ClienteCreateDTO clienteCreateDTO) {
        ClienteListDTO clienteCreated = clienteService.createCliente(clienteCreateDTO);
        return new ResponseEntity<>(clienteCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteListDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteCreateDTO clienteCreateDTO) {
        ClienteListDTO updatedCliente = clienteService.updateCliente(id, clienteCreateDTO);
        return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<ClienteListDTO>> listarClientes() {
        List<ClienteListDTO> clientes = clienteService.listarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteListDTO> buscarClientePorId(@PathVariable Long id) {
        ClienteListDTO cliente = clienteService.buscarClientePorId(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/calcular-score/{id}")
    public ResponseEntity<Float> calcularScore(@PathVariable Long id) {
        Float score = clienteService.calcularScore(id);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
