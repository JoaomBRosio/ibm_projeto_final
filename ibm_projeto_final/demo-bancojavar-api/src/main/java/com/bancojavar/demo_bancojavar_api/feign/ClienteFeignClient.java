package com.bancojavar.demo_bancojavar_api.feign;

import com.bancojavar.demo_bancojavar_api.dto.ClienteCreateDTO;
import com.bancojavar.demo_bancojavar_api.dto.ClienteListDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "clienteService", url = "http://localhost:8080/clientes")
public interface ClienteFeignClient {

    @PostMapping
    ClienteListDTO createCliente(@RequestBody ClienteCreateDTO clienteCreateDTO);

    @GetMapping
    List<ClienteListDTO> listarClientes();

    @GetMapping("/{id}")
    ClienteListDTO buscarClientePorId(@PathVariable Long id);

    @PutMapping("/{id}")
    ClienteListDTO updateCliente(@PathVariable Long id, @RequestBody ClienteCreateDTO clienteCreateDTO);

    @DeleteMapping("/{id}")
    void deleteCliente(@PathVariable Long id);
}
