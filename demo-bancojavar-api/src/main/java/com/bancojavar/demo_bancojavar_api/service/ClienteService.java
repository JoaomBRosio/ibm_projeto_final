package com.bancojavar.demo_bancojavar_api.service;

import com.bancojavar.demo_bancojavar_api.dto.ClienteListDTO;
import com.bancojavar.demo_bancojavar_api.entity.Cliente;
import com.bancojavar.demo_bancojavar_api.feign.FeignClientBanco;
import com.bancojavar.demo_bancojavar_api.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@RequiredArgsConstructor
@Service
public class ClienteService {

    private final FeignClientBanco feignClientBanco;

    private final ClienteRepository clienteRepository;

    public ClienteService(FeignClientBanco feignClientBanco, ClienteRepository clienteRepository) {
        this.feignClientBanco = feignClientBanco;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional(readOnly = true)
    public List<ClienteListDTO> buscarTodos() {
        return feignClientBanco.listar();
    }


    public Float calculoDoScoreCredito(Float saldo){
        return saldo * 0.1f;
    }
}
