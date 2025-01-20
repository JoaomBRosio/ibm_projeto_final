package com.bancojavar.demo_bancojavar_api.service;

import com.bancojavar.demo_bancojavar_api.dto.ClienteCreateDTO;
import com.bancojavar.demo_bancojavar_api.dto.ClienteListDTO;
import com.bancojavar.demo_bancojavar_api.feign.ClienteFeignClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteFeignClient clienteFeignClient;

    public ClienteService(ClienteFeignClient clienteFeignClient) {
        this.clienteFeignClient = clienteFeignClient;
    }

    public ClienteListDTO createCliente(ClienteCreateDTO clienteCreateDTO) {
        return clienteFeignClient.createCliente(clienteCreateDTO);
    }

    public List<ClienteListDTO> listarClientes() {
        return clienteFeignClient.listarClientes();
    }

    public ClienteListDTO buscarClientePorId(Long id) {
        return clienteFeignClient.buscarClientePorId(id);
    }

    public ClienteListDTO updateCliente(Long id, ClienteCreateDTO clienteCreateDTO) {
        return clienteFeignClient.updateCliente(id, clienteCreateDTO);
    }

    public void deleteCliente(Long id) {
        clienteFeignClient.deleteCliente(id);
    }

    public Float calcularScore(Long id) {
        ClienteListDTO cliente = clienteFeignClient.buscarClientePorId(id);
        return cliente.getSaldo_cc() * 0.1f;
    }
}
