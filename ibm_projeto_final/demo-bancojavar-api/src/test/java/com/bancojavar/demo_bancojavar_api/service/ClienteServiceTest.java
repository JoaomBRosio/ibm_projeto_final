package com.bancojavar.demo_bancojavar_api.service;

import com.bancojavar.demo_bancojavar_api.dto.ClienteCreateDTO;
import com.bancojavar.demo_bancojavar_api.dto.ClienteListDTO;
import com.bancojavar.demo_bancojavar_api.feign.ClienteFeignClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteFeignClient clienteFeignClient;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCliente() {
        ClienteCreateDTO createDTO = new ClienteCreateDTO();
        ClienteListDTO listDTO = new ClienteListDTO();

        when(clienteFeignClient.createCliente(createDTO)).thenReturn(listDTO);

        ClienteListDTO result = clienteService.createCliente(createDTO);

        assertEquals(listDTO, result);
    }

    @Test
    public void testListarClientes() {
        List<ClienteListDTO> list = Arrays.asList(new ClienteListDTO(), new ClienteListDTO());

        when(clienteFeignClient.listarClientes()).thenReturn(list);

        List<ClienteListDTO> result = clienteService.listarClientes();

        assertEquals(list, result);
    }

    @Test
    public void testBuscarClientePorId() {
        ClienteListDTO listDTO = new ClienteListDTO();

        when(clienteFeignClient.buscarClientePorId(1L)).thenReturn(listDTO);

        ClienteListDTO result = clienteService.buscarClientePorId(1L);

        assertEquals(listDTO, result);
    }

    @Test
    public void testUpdateCliente() {
        ClienteCreateDTO createDTO = new ClienteCreateDTO();
        ClienteListDTO listDTO = new ClienteListDTO();

        when(clienteFeignClient.updateCliente(1L, createDTO)).thenReturn(listDTO);

        ClienteListDTO result = clienteService.updateCliente(1L, createDTO);

        assertEquals(listDTO, result);
    }

    @Test
    public void testDeleteCliente() {
        doNothing().when(clienteFeignClient).deleteCliente(1L);

        clienteService.deleteCliente(1L);

        verify(clienteFeignClient, times(1)).deleteCliente(1L);
    }

    @Test
    public void testCalcularScore() {
        ClienteListDTO listDTO = new ClienteListDTO();
        listDTO.setSaldo_cc(100.0f);

        when(clienteFeignClient.buscarClientePorId(1L)).thenReturn(listDTO);

        float score = clienteService.calcularScore(1L);

        assertEquals(10.0f, score);
    }
}
