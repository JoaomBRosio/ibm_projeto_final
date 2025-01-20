package com.bancojavar.demo_bancojavar_api.controller;

import com.bancojavar.demo_bancojavar_api.entity.Cliente;
import com.bancojavar.demo_bancojavar_api.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clientes", description = "Contém todas as operações relativas aos recursos para se manter um usuário (criar, ver, atualizar e deletar")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(
            summary = "Criar um novo cliente", description = "Recurso de criação de um novo cliente.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody @Valid Cliente cliente) {
        try {
            Cliente savedCliente = clienteService.salvar(cliente);
            return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(
            summary = "Atualizar um  cliente", description = "Recurso de atualização de um cliente.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody @Valid Cliente cliente) {
        try {
            Cliente existingCliente = clienteService.buscarPorId(id);
            existingCliente.setUsername(cliente.getUsername());
            existingCliente.setTelefone(cliente.getTelefone());
            existingCliente.setCorrentista(cliente.getCorrentista());
            existingCliente.setSaldo_cc(cliente.getSaldo_cc());
            existingCliente.setScore_credito(cliente.getScore_credito());
            Cliente updatedCliente = clienteService.salvar(existingCliente);
            return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(
            summary = "Deletar um cliente", description = "Recurso para deletar cliente.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Cliente excluido com sucesso",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        try {
            clienteService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(
            summary = "Buscar todos os clientes", description = "Recurso para buscar todos os clientes.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Clientes recuperados com sucesso",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.buscarTodos();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @Operation(
            summary = "Buscar um cliente", description = "Recurso para buscar um cliente.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cliente recuperado com sucesso",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
}
