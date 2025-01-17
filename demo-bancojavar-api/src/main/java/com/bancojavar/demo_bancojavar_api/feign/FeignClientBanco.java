package com.bancojavar.demo_bancojavar_api.feign;

import com.bancojavar.demo_bancojavar_api.dto.ClienteListDTO;
import com.bancojavar.demo_bancojavar_api.entity.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(
        url = "http://localhost:8080/api/v1/clientes",
        name = "cad-banco-javer")
public interface FeignClientBanco {

    @GetMapping()
    List<ClienteListDTO> listar();

    @PostMapping
    ClienteListDTO cadastrar(Cliente cliente);

}
