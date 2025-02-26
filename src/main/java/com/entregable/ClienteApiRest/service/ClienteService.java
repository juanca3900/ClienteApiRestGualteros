package com.entregable.ClienteApiRest.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entregable.ClienteApiRest.dto.ClienteDto;
import com.entregable.ClienteApiRest.models.Cliente;
import com.entregable.ClienteApiRest.repository.ClienteRepository;

@Service
public class ClienteService implements ClienteServiceI<Cliente, ClienteDto> {

    private ClienteRepository clienteRepository;
    
    public ClienteService(@Autowired ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDto crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente).toClienteDto();
    }


    @Override
    public ClienteDto obtenerById(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).get();
        Integer edadCliente = LocalDate.now().getYear()-cliente.getFecha().getYear();
        return ClienteDto.builder().nombreDto(cliente.getNombre()).apellidoDto(cliente.getApellido()).nacimientoDto(cliente.getFecha()).edad(edadCliente).build();
    }

    @Override
    public List<ClienteDto> obtenerTodos() {
        return clienteRepository.findAll().stream().map(it->it.toClienteDto()).toList();
    }
    @Override
    public void eliminarTodos() {
        clienteRepository.deleteAll();
    }

}
