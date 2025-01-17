package com.bancojavar.demo_bancojavar_api.dto;

import com.bancojavar.demo_bancojavar_api.entity.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {

    public static ClienteListDTO toDto(ClienteListDTO cliente) {
        if (cliente == null) {
            return null;
        } else {
            return new ClienteListDTO(cliente.getId(), cliente.getNome(), cliente.getSaldo_cc());
        }
    }

    public static List<ClienteListDTO> toDto(List<ClienteListDTO> entities) {
        return entities.stream()
                .map(ClienteMapper::toDto)
                .collect(Collectors.toList());
    }

    public static Cliente toEntity(ClienteCreateDTO dto){
        if (dto == null){
            return null;
        }else {
            Cliente entity = new Cliente();
            entity.setUsername(dto.getNome());
            entity.setSaldo_cc(dto.getSaldo_cc());
            return entity;
        }
    }
}
