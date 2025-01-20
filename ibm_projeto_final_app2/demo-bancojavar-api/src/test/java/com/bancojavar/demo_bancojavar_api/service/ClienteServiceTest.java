package com.bancojavar.demo_bancojavar_api.service;

import com.bancojavar.demo_bancojavar_api.entity.Cliente;
import com.bancojavar.demo_bancojavar_api.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvar() {
        Cliente cliente = new Cliente();
        cliente.setSaldo_cc(100.0f);

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente savedCliente = clienteService.salvar(cliente);

        assertEquals(cliente.getSaldo_cc() * 0.1f, savedCliente.getScore_credito());
        assertEquals(cliente, savedCliente);
    }

    @Test
    public void testBuscarPorId() {
        Cliente cliente = new Cliente();

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente foundCliente = clienteService.buscarPorId(1L);

        assertEquals(cliente, foundCliente);
    }

    @Test
    public void testBuscarPorIdNaoExistente() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        try {
            clienteService.buscarPorId(1L);
        } catch (Exception e) {
            assertEquals("RuntimeException", e.getClass().getSimpleName());
            assertEquals("Cliente não encontrado.", e.getMessage());
        }
    }

    @Test
    public void testBuscarTodos() {
        List<Cliente> list = Arrays.asList(new Cliente(), new Cliente());

        when(clienteRepository.findAll()).thenReturn(list);

        List<Cliente> foundClientes = clienteService.buscarTodos();

        assertEquals(list, foundClientes);
    }

    @Test
    public void testDeletar() {
        doNothing().when(clienteRepository).deleteById(1L);

        clienteService.deletar(1L);

        verify(clienteRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeletarNaoExistente() {
        doThrow(new RuntimeException("Cliente não encontrado.")).when(clienteRepository).deleteById(1L);

        try {
            clienteService.deletar(1L);
        } catch (Exception e) {
            assertEquals("RuntimeException", e.getClass().getSimpleName());
            assertEquals("Cliente não encontrado.", e.getMessage());
        }

        verify(clienteRepository, times(1)).deleteById(1L);
    }
}
