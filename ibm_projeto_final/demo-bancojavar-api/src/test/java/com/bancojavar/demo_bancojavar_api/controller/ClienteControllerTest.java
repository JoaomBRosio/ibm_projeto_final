package com.bancojavar.demo_bancojavar_api.controller;

import com.bancojavar.demo_bancojavar_api.dto.ClienteCreateDTO;
import com.bancojavar.demo_bancojavar_api.dto.ClienteListDTO;
import com.bancojavar.demo_bancojavar_api.service.ClienteService;
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

    public ClienteControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCliente() {
        ClienteCreateDTO createDTO = new ClienteCreateDTO();
        ClienteListDTO listDTO = new ClienteListDTO();

        when(clienteService.createCliente(createDTO)).thenReturn(listDTO);

        ResponseEntity<ClienteListDTO> response = clienteController.createCliente(createDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(listDTO, response.getBody());
    }

    @Test
    public void testUpdateCliente() {
        ClienteCreateDTO createDTO = new ClienteCreateDTO();
        ClienteListDTO listDTO = new ClienteListDTO();

        when(clienteService.updateCliente(1L, createDTO)).thenReturn(listDTO);

        ResponseEntity<ClienteListDTO> response = clienteController.updateCliente(1L, createDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listDTO, response.getBody());
    }

    @Test
    public void testDeleteCliente() {
        doNothing().when(clienteService).deleteCliente(1L);

        ResponseEntity<Void> response = clienteController.deleteCliente(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void testListarClientes() {
        List<ClienteListDTO> list = Arrays.asList(new ClienteListDTO(), new ClienteListDTO());

        when(clienteService.listarClientes()).thenReturn(list);

        ResponseEntity<List<ClienteListDTO>> response = clienteController.listarClientes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(list, response.getBody());
    }

    @Test
    public void testBuscarClientePorId() {
        ClienteListDTO listDTO = new ClienteListDTO();

        when(clienteService.buscarClientePorId(1L)).thenReturn(listDTO);

        ResponseEntity<ClienteListDTO> response = clienteController.buscarClientePorId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listDTO, response.getBody());
    }

    @Test
    public void testCalcularScore() {
        float score = 10.0f;

        when(clienteService.calcularScore(1L)).thenReturn(score);

        ResponseEntity<Float> response = clienteController.calcularScore(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(score, response.getBody());
    }
}
