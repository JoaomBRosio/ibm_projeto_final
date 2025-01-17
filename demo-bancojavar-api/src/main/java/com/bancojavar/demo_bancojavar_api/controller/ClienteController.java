package com.bancojavar.demo_bancojavar_api.controller;

import com.bancojavar.demo_bancojavar_api.dto.ClienteCreateDTO;
import com.bancojavar.demo_bancojavar_api.dto.ClienteListDTO;
import com.bancojavar.demo_bancojavar_api.entity.Cliente;
import com.bancojavar.demo_bancojavar_api.dto.ClienteMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bancojavar.demo_bancojavar_api.feign.FeignClientBanco;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final FeignClientBanco feignClientBanco;

    @Autowired
    public ClienteController(FeignClientBanco feignClientBanco) {
        this.feignClientBanco = feignClientBanco;
    }

    @PostMapping
    public ResponseEntity<ClienteListDTO> createCliente(@RequestBody @Valid ClienteCreateDTO clienteDTO) {
        Cliente cliente = ClienteMapper.toEntity(clienteDTO);
        ClienteListDTO clienteCreated = feignClientBanco.cadastrar(cliente);
        return ResponseEntity.ok(clienteCreated);
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Service is up and running");
    }
}
