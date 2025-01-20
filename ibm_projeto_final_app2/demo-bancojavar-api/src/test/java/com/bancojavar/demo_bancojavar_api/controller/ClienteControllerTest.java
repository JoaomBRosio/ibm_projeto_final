package com.bancojavar.demo_bancojavar_api.controller;

import com.bancojavar.demo_bancojavar_api.entity.Cliente;
import com.bancojavar.demo_bancojavar_api.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private ClienteService clienteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCliente() {
        Cliente cliente = new Cliente();
        cliente.setSaldo_cc(100.0f);

        when(clienteService.salvar(cliente)).thenReturn(cliente);

        ResponseEntity<Cliente> response = clienteController.createCliente(cliente);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(cliente, response.getBody());
    }

    @Test
    public void testUpdateCliente() {
        Cliente cliente = new Cliente();
        cliente.setSaldo_cc(100.0f);
        Cliente existingCliente = new Cliente();
        existingCliente.setSaldo_cc(50.0f);

        when(clienteService.buscarPorId(1L)).thenReturn(existingCliente);
        when(clienteService.salvar(existingCliente)).thenReturn(existingCliente);

        ResponseEntity<Cliente> response = clienteController.updateCliente(1L, cliente);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(existingCliente, response.getBody());
    }

    @Test
    public void testUpdateClienteComDadosInvalidos() {
        Cliente cliente = new Cliente(); // Dados faltantes

        ResponseEntity<Cliente> response = clienteController.updateCliente(1L, cliente);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testDeleteCliente() {
        doNothing().when(clienteService).deletar(1L);

        ResponseEntity<Void> response = clienteController.deleteCliente(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void testListarClientes() {
        List<Cliente> list = Arrays.asList(new Cliente(), new Cliente());

        when(clienteService.buscarTodos()).thenReturn(list);

        ResponseEntity<List<Cliente>> response = clienteController.listarClientes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(list, response.getBody());
    }

    @Test
    public void testBuscarClientePorId() {
        Cliente cliente = new Cliente();

        when(clienteService.buscarPorId(1L)).thenReturn(cliente);

        ResponseEntity<Cliente> response = clienteController.buscarClientePorId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
    }
}
