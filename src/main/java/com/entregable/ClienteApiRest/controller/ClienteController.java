package com.entregable.ClienteApiRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entregable.ClienteApiRest.dto.ClienteDto;
import com.entregable.ClienteApiRest.models.Cliente;
import com.entregable.ClienteApiRest.service.ClienteService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="/clientes")
@AllArgsConstructor(onConstructor = @__(@Autowired))//inyeccion de dependencias
public class ClienteController {
    private ClienteService service;//llamaamos al service
    //agregar nuevo cliente
    @PostMapping
    public ResponseEntity<ClienteDto> agregarCliente(@RequestBody Cliente clienteNuevo ){
        return new ResponseEntity<>(service.crearCliente(clienteNuevo), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> obtenerClientePorId(@PathVariable("id") Long idCliente){
        //validamos que el cliente exista en la base de datos, si no, retornamos un 404 Not Found
        try {
            return new ResponseEntity<>(service.obtenerById(idCliente), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
